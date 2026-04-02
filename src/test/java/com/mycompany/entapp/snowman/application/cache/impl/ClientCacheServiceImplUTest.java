package com.mycompany.entapp.snowman.application.cache.impl;

import com.mycompany.entapp.snowman.infrastructure.cache.ClientCachePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ClientCacheServiceImplUTest {

    @Mock
    private ClientCachePort clientCachePort;

    @InjectMocks
    private ClientCacheServiceImpl clientCacheService;

    @Test
    void testClearCache() {
        clientCacheService.clearCache();
        verify(clientCachePort).refreshCache();
    }
}
