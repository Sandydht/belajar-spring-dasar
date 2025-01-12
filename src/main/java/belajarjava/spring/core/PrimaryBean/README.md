# Primary Bean
- Jika terjadi duplicate bean, selain kita sebutkan nama bean-nya ketika ingin mengakses bean-nya, kita juga bisa pilih salah satu bean menjadi primary.
- Dengan memilih salah satunya menjadi primary, secara otomatis jika kita mengakses bean tanpa menyebutkan bean-nya, secara otomatis primary-nya yang akan dipilih.
- Untuk memilih primary bean, kita bisa tambahkan annotation ``` @Primary ```.
- Kode: PrimaryBean
```java
@Primary
@Bean
public Foo foo1() {
    Foo foo = new Foo();
    return foo;
}

@Bean
public Foo foo2() {
    Foo foo = new Foo();
    return foo;
}
```
- Kode: Mengakses Primary Bean
```java
Foo foo = applicationContext.getBean(Foo.class);
Foo foo1 = applicationContext.getBean("foo1", Foo.class);
Foo foo2 = applicationContext.getBean("foo2", Foo.class);

Assertions.assertSame(foo, foo1);
Assertions.assertNotSame(foo1, foo2);
```