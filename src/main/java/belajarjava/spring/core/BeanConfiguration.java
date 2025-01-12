package belajarjava.spring.core;

import belajarjava.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public Foo foo3() {
        Foo foo3 = new Foo();
        System.out.println("Create new foo");
        return foo3;
    }
}
