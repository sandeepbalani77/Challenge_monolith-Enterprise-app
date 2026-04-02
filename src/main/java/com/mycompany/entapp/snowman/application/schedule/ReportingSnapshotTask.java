package com.mycompany.entapp.snowman.application.schedule;

import com.mycompany.entapp.snowman.application.schedule.service.ReportingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportingSnapshotTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportingSnapshotTask.class);

    @Autowired
    private ReportingService reportingService;

    @Scheduled(fixedRate = 5000, initialDelay = 1000)
    public void executeTask() {
        LOGGER.info("Running Reporting Snapshot Task");
        ReportingData reportingData = reportingService.retrieveReportingData();
        LOGGER.info("Reporting data: {}", reportingData);
    }
}
