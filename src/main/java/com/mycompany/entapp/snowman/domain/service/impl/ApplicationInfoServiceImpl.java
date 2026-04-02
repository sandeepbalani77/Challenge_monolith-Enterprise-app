package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.model.AppInfo;
import com.mycompany.entapp.snowman.domain.repository.ApplicationInfoRepository;
import com.mycompany.entapp.snowman.domain.service.ApplicationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationInfoServiceImpl implements ApplicationInfoService {

    @Autowired
    private ApplicationInfoRepository applicationInfoRepository;

    @Override
    public AppInfo getApplicationInfo() {
        return applicationInfoRepository.getApplicationInfo();
    }
}
