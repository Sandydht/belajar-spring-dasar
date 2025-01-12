# Depends On
- Saat sebuah bean membutuhkan bean lain, secara otomatis bean tersebut akan dibuat setelah bean yang dibutuhkan dibuat.
- Namun bagaiman jika bean tersebut membutuhkan bean lain, namun kita ingin sebuah bean dibuat setelah bean lain dibuat ?.
- Jika ada kasus seperti itu, kita bisa menggunakan annotation ``` @DependsOn(value={"namaBean"}) ```
- Secara otomatis, Spring akan memprioritaskan pembuatan bean yang terdapat di DependsOn terlebih dahulu.
- Kode: DependsOn
```java
@Bean
@DependsOn({"bar"})
public Foo foo() {
    log.info("Create new Foo");
    return new Foo();
}

@Bean
Bar bar() {
    log.info("Create new Bar");
    return new Bar();
}
```