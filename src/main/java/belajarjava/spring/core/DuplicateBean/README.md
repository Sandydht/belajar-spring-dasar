# Duplicate Bean
- Di Spring, kita bisa mendaftarkan beberapa bean dengan tipe yang sama.
- Namun perlu diperhatikan, jika kita membuat bean dengan tipe data yang sama, maka kita harus menggunakan nama bean yang berbeda.
- Selain itu, saat kita mengakses bean-nya, kita wajib menyebutkan nama bean-nya, karena jika tidak, Spring akan bingung harus mengakses bean yang mana.
- Kode: Duplicate Bean
```java
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
- Kode: Mengakses Duplicate Bean
```java
Foo foo1 = applicationContext.getBean("foo1", Foo.class);
Foo foo2 = applicationContext.getBean("foo2", Foo.class);

Assertions.assertNotSame(foo1, foo2);
```