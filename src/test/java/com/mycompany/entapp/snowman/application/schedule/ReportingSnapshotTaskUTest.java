package com.mycompany.entapp.snowman.application.schedule;

import com.mycompany.entapp.snowman.application.schedule.service.ReportingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportingSnapshotTaskUTest {

    @Mock
    private ReportingService reportingService;

    @InjectMocks
    private ReportingSnapshotTask reportingSnapshotTask;

    @Test
    void testExecuteTask() {
        when(reportingService.retrieveReportingData()).thenReturn(new ReportingData());
        reportingSnapshotTask.executeTask();
        verify(reportingService).retrieveReportingData();
    }
}
