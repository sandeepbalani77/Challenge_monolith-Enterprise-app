package com.mycompany.entapp.snowman.infrastructure.cache.impl;

import org.junit.jupiter.api.Test;
import org.springframework.cache.annotation.CacheEvict;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ClientCacheAdapterUTest {

    @Test
    void testRefreshCacheHasCacheEvictAnnotation() throws NoSuchMethodException {
        Method method = ClientCacheAdapter.class.getMethod("refreshCache");
        CacheEvict cacheEvict = method.getAnnotation(CacheEvict.class);
        assertNotNull(cacheEvict);
        assertEquals("clientFindCache", cacheEvict.value()[0]);
        assertTrue(cacheEvict.allEntries());
    }

    @Test
    void testRefreshCacheDoesNotThrow() {
        ClientCacheAdapter adapter = new ClientCacheAdapter();
        assertDoesNotThrow(adapter::refreshCache);
    }
}
