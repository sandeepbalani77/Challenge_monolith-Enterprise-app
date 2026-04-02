package com.mycompany.entapp.snowman.infrastructure.management;

import com.mycompany.entapp.snowman.application.cache.ClientCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/management/cache")
public class CacheManagementRestEndpoint {

    @Autowired
    private ClientCacheService clientCacheService;

    @PostMapping("/refresh")
    public ResponseEntity<Void> refreshCache() {
        clientCacheService.clearCache();
        return ResponseEntity.ok().build();
    }
}
