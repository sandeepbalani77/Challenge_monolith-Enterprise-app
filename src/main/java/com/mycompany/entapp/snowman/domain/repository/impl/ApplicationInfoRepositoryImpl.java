package com.mycompany.entapp.snowman.domain.repository.impl;

import com.mycompany.entapp.snowman.domain.model.AppInfo;
import com.mycompany.entapp.snowman.domain.repository.ApplicationInfoRepository;
import com.mycompany.entapp.snowman.infrastructure.db.jpa.AppInfoJpaRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApplicationInfoRepositoryImpl implements ApplicationInfoRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationInfoRepositoryImpl.class);

    @Autowired
    private AppInfoJpaRepository appInfoJpaRepository;

    private AppInfo appInfo;

    @PostConstruct
    public void initialize() {
        LOGGER.info("Initializing ApplicationInfoRepository");
        List<AppInfo> appInfoList = appInfoJpaRepository.findAll();
        if (!appInfoList.isEmpty()) {
            this.appInfo = appInfoList.get(0);
        }
        LOGGER.info("Loaded application info: {}", appInfo);
    }

    @Override
    public AppInfo getApplicationInfo() {
        return appInfo;
    }
}
