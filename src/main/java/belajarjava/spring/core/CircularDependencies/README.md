# Circular Dependencies
- Hati - hati dengan circular dependencies.
- Circular Dependencies adalah kasus dimana sebuah lingkaran dependency terjadi, misal bean A membutuhkan bean B, bean B membutuhkan bean C, dan bean C membutuhkan bean A.
- Jika terjadi cyclic seperti ini, secara otomatis Spring bisa mendeteksi dan akan menganggap bahwa itu error.
- Kode: Contoh Circular Configuration
```java
@Bean
public CyclicA cyclicA(CyclicB cyclicB) {
    return new CyclicA(cyclicB);
}

@Bean
public CyclicB cyclicB(CyclicC cyclicC) {
    return new CyclicB(cyclicC);
}

@Bean
public CyclicC cyclicC(CyclicA cyclicA) {
    return new CyclicC(cyclicA);
}
```
- Kode: Error Circular Dependencies
```java
try {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CyclicConfiguraton.class);
    Assertions.fail("It must be fail because cyclic");
} catch(error) {
    exception.printStackTrace();
}
```
