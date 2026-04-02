package com.mycompany.entapp.snowman.integration;

import com.mycompany.entapp.snowman.EnterpriseApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = EnterpriseApplication.class)
class ApplicationStartupITest {

    @Test
    void contextLoads() {
        // Verifies Spring Boot application context loads successfully
    }
}
