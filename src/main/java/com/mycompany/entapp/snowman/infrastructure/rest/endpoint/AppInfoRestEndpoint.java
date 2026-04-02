package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.domain.model.AppInfo;
import com.mycompany.entapp.snowman.domain.service.ApplicationInfoService;
import com.mycompany.entapp.snowman.infrastructure.rest.mappers.AppInfoResourceMapper;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.AppInfoResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appinfo")
public class AppInfoRestEndpoint {

    @Autowired
    private ApplicationInfoService applicationInfoService;

    @GetMapping
    public ResponseEntity<AppInfoResource> getAppInfo() {
        AppInfo appInfo = applicationInfoService.getApplicationInfo();
        if (appInfo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(AppInfoResourceMapper.mapAppInfoToResource(appInfo));
    }
}
