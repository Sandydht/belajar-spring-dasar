package belajarjava.spring.core;

import belajarjava.spring.core.data.Bar;
import belajarjava.spring.core.data.Foo;
import belajarjava.spring.core.data.FooBar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjectionConfiguration  {
    @Bean
    public Foo foo() {
        return new Foo();
    }

    @Bean
    public Bar bar() {
        return new Bar();
    }

    @Bean
    public FooBar fooBar(Foo foo, Bar bar) {
        return new FooBar(foo, bar);
    }
}
