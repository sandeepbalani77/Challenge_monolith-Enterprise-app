# Testing: Snowman Employee Management System

## Overview
Spring Boot 3.3 REST API with H2 in-memory DB, Liquibase migrations, Caffeine cache, embedded Artemis JMS.

## Build & Start
```bash
# Build uber jar (skip tests for faster build)
mvn clean package -DskipTests -q

# Start on port 8090
java -jar target/Snowman.jar &

# Wait for readiness (takes ~20s)
for i in $(seq 1 30); do
  curl -s -o /dev/null -w "%{http_code}" http://localhost:8090/actuator/health 2>/dev/null | grep -q 200 && break
  sleep 1
done
```

## Run Unit + Integration Tests
```bash
mvn clean test   # Expect 119 tests pass
```

Note: Use `mvn clean test` (not just `mvn test`) if you've changed JPA entity annotations — stale compiled classes can cause `NoClassDefFoundError` in test discovery.

## REST Endpoints to Test

### Core Endpoints
| Method | URL | Seed Data | Expected |
|--------|-----|-----------|----------|
| GET | `/actuator/health` | n/a | 200 `{"status":"UP"}` |
| GET | `/app/info` | id=1 | 200 `{"id":1,"version":"1.0.0"}` |
| GET | `/employee/{id}` | ids 1-4 | 200 with employee JSON |
| GET | `/client/{id}` | ids 1-6 | 200 with client + projects |
| GET | `/project/{id}` | ids 1-5 | 200 with project JSON |
| GET | `/user/{id}` | ids 1-4 | 200 with user JSON |

### Client CRUD
| Method | URL | Body | Expected |
|--------|-----|------|----------|
| POST | `/client/new` | `{"clientId":N,"clientName":"..."}` | 201 |
| POST | `/client/update` | `{"clientId":N,"clientName":"..."}` | 200 |
| DELETE | `/client/{id}` | n/a | 200 |

### Backward-Compatible URLs
- `DELETE /employee/{id}/delete` — old-style delete URL
- `GET /app/info` — not `/appinfo`

### Validation Guards
- `POST /client/new` with existing ID → 400 "Client already exists"
- `POST /client/update` with non-existent ID → 400 "Client doesn't exists"
- `DELETE /client/{id}` with non-existent ID → 400 "Client doesn't exists"

## Known Issues & Gotchas

### Lazy-Loading
`Client.projects` is `@OneToMany(fetch = LAZY)` and `open-in-view: false`. The `getClient()` service method uses `Hibernate.initialize()` to eagerly load within the `@Transactional` boundary. If you see `LazyInitializationException` on `GET /client/{id}`, check that `@Transactional(readOnly = true)` and `Hibernate.initialize(client.getProjects())` are present in `ClientServiceImpl.getClient()`.

### Client Cache After Create
Creating a new client via `POST /client/new` may result in `GET /client/{id}` returning 404 due to Caffeine cache storing a `null` from the duplicate-check query in `createClient()`. The `createClient` repository method lacks `@CacheEvict`/`@CachePut`. Seed data clients (ids 1-6) are not affected since they are loaded before any cache entries exist.

### External Client System
`ClientServiceImpl.getClient()` attempts to call `http://localhost:9999/clients/{id}` to fetch project data from an external system. This always fails (connection refused) and is caught/logged. The `processResponse()` method doesn't actually parse JSON — it just logs and sets an empty projects set. This is a known limitation.

### H2 Reserved Words
The `user` table name is a reserved word in H2. The `User` entity uses `@Table(name = "\"user\"")` for explicit quoting. Do NOT use `globally_quoted_identifiers: true` — it causes Liquibase/H2 case-sensitivity conflicts (`app_info` vs `APP_INFO`).

## Devin Secrets Needed
None — the app uses H2 in-memory DB with no external credentials.

## Test Evidence Collection
This is a REST API (no UI), so testing is shell-only via curl. No screen recording needed. Collect curl outputs as text evidence.
