package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.model.AppInfo;
import com.mycompany.entapp.snowman.domain.repository.ApplicationInfoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApplicationInfoServiceImplUTest {

    @Mock
    private ApplicationInfoRepository applicationInfoRepository;

    @InjectMocks
    private ApplicationInfoServiceImpl applicationInfoService;

    @Test
    void testGetApplicationInfo() {
        AppInfo appInfo = new AppInfo();
        appInfo.setId(1);
        appInfo.setVersion("1.0");
        when(applicationInfoRepository.getApplicationInfo()).thenReturn(appInfo);
        AppInfo result = applicationInfoService.getApplicationInfo();
        assertEquals("1.0", result.getVersion());
    }

    @Test
    void testGetApplicationInfoReturnsNull() {
        when(applicationInfoRepository.getApplicationInfo()).thenReturn(null);
        assertNull(applicationInfoService.getApplicationInfo());
    }
}
