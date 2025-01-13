package belajarjava.spring.core.LifeCycle;

import belajarjava.spring.core.data.Connection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleConfiguration {
    @Bean
    public Connection connection() {
        return new Connection();
    }
}
