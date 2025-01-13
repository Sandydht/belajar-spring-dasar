package belajarjava.spring.core.Scope;

import belajarjava.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeConfiguration {
    @Bean
    @Scope("prototype")
    public Foo foo() {
        return new Foo();
    }
}
