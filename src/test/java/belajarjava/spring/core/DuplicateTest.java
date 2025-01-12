package belajarjava.spring.core;

import belajarjava.spring.core.DuplicateBean.DuplicateConfiguration;
import belajarjava.spring.core.data.Foo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DuplicateTest {
    private ApplicationContext context;

    @BeforeEach
    void setup() {
        context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);
    }

    @Test
    void testDuplicate() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            context.getBean(Foo.class);
        });
    }

    @Test
    void getBean() {
        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);

        Assertions.assertNotSame(foo1, foo2);
    }
}
