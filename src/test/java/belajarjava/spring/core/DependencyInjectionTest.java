package belajarjava.spring.core;

import belajarjava.spring.core.data.Bar;
import belajarjava.spring.core.data.Foo;
import belajarjava.spring.core.data.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyInjectionTest {
    private ApplicationContext applicationContext;

    @BeforeEach
    void setup() {
        applicationContext = new AnnotationConfigApplicationContext(DependencyInjectionConfiguration.class);
    }

    @Test
    void testDI() {
//        Foo foo = applicationContext.getBean(Foo.class);
//        Bar bar = applicationContext.getBean(Bar.class);
//        FooBar fooBar = applicationContext.getBean(FooBar.class);

//        System.out.println("fooBar: " + fooBar);

//        Assertions.assertSame(foo, fooBar.getFoo());
//        Assertions.assertSame(bar, fooBar.getBar());
    }
}
