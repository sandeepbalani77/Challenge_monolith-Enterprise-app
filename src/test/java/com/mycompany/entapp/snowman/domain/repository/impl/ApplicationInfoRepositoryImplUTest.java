package com.mycompany.entapp.snowman.domain.repository.impl;

import com.mycompany.entapp.snowman.domain.model.AppInfo;
import com.mycompany.entapp.snowman.infrastructure.db.jpa.AppInfoJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApplicationInfoRepositoryImplUTest {

    @Mock
    private AppInfoJpaRepository appInfoJpaRepository;

    @InjectMocks
    private ApplicationInfoRepositoryImpl applicationInfoRepository;

    @Test
    void testInitializeLoadsAppInfo() {
        AppInfo appInfo = new AppInfo();
        appInfo.setId(1);
        appInfo.setVersion("1.0");
        when(appInfoJpaRepository.findAll()).thenReturn(List.of(appInfo));
        applicationInfoRepository.initialize();
        assertEquals(appInfo, applicationInfoRepository.getApplicationInfo());
    }

    @Test
    void testInitializeWithEmptyList() {
        when(appInfoJpaRepository.findAll()).thenReturn(Collections.emptyList());
        applicationInfoRepository.initialize();
        assertNull(applicationInfoRepository.getApplicationInfo());
    }
}
