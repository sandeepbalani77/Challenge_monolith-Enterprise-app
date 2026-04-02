package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.domain.model.AppInfo;
import com.mycompany.entapp.snowman.domain.service.ApplicationInfoService;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.AppInfoResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppInfoRestEndpointUTest {

    @Mock
    private ApplicationInfoService applicationInfoService;

    @InjectMocks
    private AppInfoRestEndpoint endpoint;

    @Test
    void testGetAppInfo() {
        AppInfo appInfo = new AppInfo();
        appInfo.setId(1);
        appInfo.setVersion("1.0");
        when(applicationInfoService.getApplicationInfo()).thenReturn(appInfo);
        ResponseEntity<AppInfoResource> response = endpoint.getAppInfo();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("1.0", response.getBody().getVersion());
    }

    @Test
    void testGetAppInfoNotFound() {
        when(applicationInfoService.getApplicationInfo()).thenReturn(null);
        ResponseEntity<AppInfoResource> response = endpoint.getAppInfo();
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
