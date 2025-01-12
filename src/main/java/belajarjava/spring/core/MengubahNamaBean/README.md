# Mengubah Nama Bean
- Secara default nama bean diambil dari nama method.
- Namun terkadang kita tidak ingin menggunakan nama method untuk nama bean.
- Saat project kita sudah besar, kadang bisa jadi nama method sama, walaupun isi bean-nya berbeda, dan di Spring nama bean itu unik (tidak boleh sama).
- Jika kita ingin mengubah nama bean, kita bisa menggunakan method ``` value() ``` milik annotation ``` @Bean ```.
- Kode: Mengubah Nama Bean
```java
@Primary
@Bean(value = "fooFirst")
public Foo foo1() {
    Foo foo = new Foo();
    return foo;
}

@Bean(value = "fooSecond")
public Foo foo2() {
    Foo foo = new Foo();
    return foo;
}
```