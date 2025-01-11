package belajarjava.spring.core;

import belajarjava.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DuplicateConfiguration {
    @Bean
    public Foo foo1() {
        return new Foo();
    }

    @Bean Foo foo2() {
        return new Foo();
    }
}
