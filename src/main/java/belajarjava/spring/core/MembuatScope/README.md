# Membuat Scope
- Jika scope yang disediakan oleh Spring tidak bisa memenuhi kebutuhan kita, kita juga bisa membuat scope sendiri.
- Caranya dengan membuat class yang implement interface Scope.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/Scope.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/Scope.html)
- Selanjutnya untuk meregistrasikannya, kita bisa membuat bean CustomScopeConfigurer
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/CustomScopeConfigurer.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/CustomScopeConfigurer.html)
- Kode: Doubleton Scope
```java
private List<Object> objects = new ArrayList<>(2);
private Long counter = -1L;

@Override
public Object get(String name, ObjectFactory<?> objectFactory) {
    counter++;

    if (objects.size() == 2) {
        int index = (int) (counter % 2);
        return objects.get(index);
    } else {
        Object object = objectFactory.getObject();
        objects.add(object);
        return object;
    }
}

@Override
public Object remove(String name) {
    if (!objects.isEmpty()) {
        return objects.remove(0);
    }
    return null;
}
```
- Kode: Register Doubleton Scope
```java
@Bean
public CustomScopeConfigurer customScopeConfigurer() {
    CustomScopeConfigurer configurer = new CustomScopeConfigurer();
    configurer.addScope("doubleton", new DoubletonScope());
    return configurer;
}

@Bean
@Scope("doubleton")
public Bar bar() {
    log.info("Create new Bar");
    return new Bar();
}
```
- Kode: Mengakses Doubleton Bean
```java
Bar bar1 = applicationContext.getBean(Bar.class);
Bar bar2 = applicationContext.getBean(Bar.class);
Bar bar3 = applicationContext.getBean(Bar.class);
Bar bar4 = applicationContext.getBean(Bar.class);

Assertions.assertSame(bar1, bar3);
Assertions.assertSame(bar2, bar4);
Assertions.assertNotSame(bar1, bar2);
Assertions.assertNotSame(bar3, bar4);
```