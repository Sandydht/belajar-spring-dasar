package belajarjava.spring.core;

import belajarjava.spring.core.LazyBean.LazyBeanConfiguration;
import belajarjava.spring.core.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyBeanTest {
    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(LazyBeanConfiguration.class);
    }

    @Test
    void testLazyBean() {
//        Foo foo = context.getBean(Foo.class); // Bean Foo hanya akan dibuat ketika dipanggil
    }
}
