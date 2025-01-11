package belajarjava.spring.core;

import belajarjava.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanNameTest {
    private ApplicationContext applicationContext;

    @BeforeEach
    void setup() {
        applicationContext = new AnnotationConfigApplicationContext(BeanNameConfiguration.class);
    }

    @Test
    void testBeanName() {
        Foo bean = applicationContext.getBean(Foo.class);
        Foo fooFirst = applicationContext.getBean("fooFirst", Foo.class);
        Foo fooSecond = applicationContext.getBean("fooSecond", Foo.class);

        Assertions.assertNotSame(fooFirst, fooSecond);
        Assertions.assertSame(bean, fooFirst);
        Assertions.assertNotSame(bean, fooSecond);
    }
}
