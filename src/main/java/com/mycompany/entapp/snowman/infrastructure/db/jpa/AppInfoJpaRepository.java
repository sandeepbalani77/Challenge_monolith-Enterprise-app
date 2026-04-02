package com.mycompany.entapp.snowman.infrastructure.db.jpa;

import com.mycompany.entapp.snowman.domain.model.AppInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppInfoJpaRepository extends JpaRepository<AppInfo, Integer> {
}
