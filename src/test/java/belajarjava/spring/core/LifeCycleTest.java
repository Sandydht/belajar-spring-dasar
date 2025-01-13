package belajarjava.spring.core;

import belajarjava.spring.core.LifeCycle.LifeCycleConfiguration;
import belajarjava.spring.core.data.Connection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleTest {
    ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
    }

    @Test
    void testLifeCycle() {
        Connection connection = context.getBean(Connection.class);
        context.close();
    }
}
