package com.mycompany.entapp.snowman.application.schedule.service.impl;

import com.mycompany.entapp.snowman.application.schedule.ReportingData;
import com.mycompany.entapp.snowman.application.schedule.service.ReportingService;
import com.mycompany.entapp.snowman.domain.service.ApplicationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportingServiceImpl implements ReportingService {

    @Autowired
    private ApplicationInfoService applicationInfoService;

    @Override
    public ReportingData retrieveReportingData() {
        ReportingData reportingData = new ReportingData();
        reportingData.setAppInfo(applicationInfoService.getApplicationInfo());
        return reportingData;
    }
}
