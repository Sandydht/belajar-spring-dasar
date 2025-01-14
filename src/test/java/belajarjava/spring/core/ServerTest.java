package belajarjava.spring.core;

import belajarjava.spring.core.LifeCycleAnnotation.ServerConfiguration;
import belajarjava.spring.core.data.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServerTest {
    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(ServerConfiguration.class);
    }

    @Test
    void testServer() {
        Server server = context.getBean(Server.class);
    }
}
