package belajarjava.spring.core;

import belajarjava.spring.core.MembuatScope.DoubletonScopeConfiguration;
import belajarjava.spring.core.data.Bar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DoubletonScopeTest {
    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(DoubletonScopeConfiguration.class);
    }

    @Test
    void testDoubletonScope() {
        Bar bar1 = context.getBean(Bar.class);
        Bar bar2 = context.getBean(Bar.class);
        Bar bar3 = context.getBean(Bar.class);
        Bar bar4 = context.getBean(Bar.class);

        Assertions.assertSame(bar1, bar3);
        Assertions.assertSame(bar2, bar4);
        Assertions.assertNotSame(bar1, bar2);
        Assertions.assertNotSame(bar3, bar4);
    }
}
