# Dependency Injection
- Dependency Injection (DI) adalah teknik dimana kita bisa mengotomatisasi proses pembuatan objek yang bergantung dengan objek lain, atau biasa disebut dependencies.
- Dependencies akan secara otomatis di-inject ke dalam objek yang membutuhkannya.

# Tanpa Dependency Injection
- Sebenarnya tanpa Dependency Injection pun, kita tetap bisa membuat aplikasi.
- Namun ketika relasi antar dependencies sangat kompleks, akan menjadi sangat sulit untuk kita jika melakukannya secara manual.
- Oleh karena itu, Dependency Injection framework seperti Spring akan sangat membantu sekali.
- Kode: Class FooBar
```java
@Data
@AllArgsConstructor
public class FooBar {
    private Foo foo;
    private Bar bar;
}
```
- Kode: Tanpa Dependency Injection
```java
var foo = new Foo();
var bar = new Bar();

var fooBar = new FooBar(foo, bar);
```

# Spring Dependency Injection
- Ketika kita membuat method untuk bean di Spring, kita bisa menambahkan parameter.
- Secara otomatis Spring akan mencarikan bean lain yang sesuai dengan tipe parameter tersebut.
- Jika ternyata tidak ada bean yang cocok, maka akan terjadi error.
- Dan jika ternyata terdapat bean lebih dari satu, maka akan terjadi error, kecuali terdapat primary bean.
- Kode: Bean Dependency Injection
```java
@Bean
public Foo foo() {
    return new Foo();
}

@Bean
public Bar bar() {
    return new Bar();
}

@Bean
public FooBar fooBar(Foo foo, Bar bar) {
    return new FooBar(foo, bar);
}
```
- Kode: Menggunakan Dependency Injection
```java
Foo foo = applicationContext.getBean("fooFirst", Foo.class);
Bar bar = applicationContext.getBean(Bar.class);
FooBar fooBar = applicationContext.getBean(FooBar.class);

Assertions.assertSame(foo, fooBar.getFoo());
Assertions.assertSame(bar, fooBar.getBar());
```

# Memilih Dependency
- Kadang saat menggunakan DI, kita ingin memilih objek mana yang akan digunakan.
- Saat ada duplicate bean dengan tipe data yang sama, secara otomatis Spring akan memilih bean yang primary.
- Namun kita juga bisa memilih secara manual, kita bisa menggunakan annotation ``` @Qualifier(value="namaBean") ``` pada parameter di method-nya.
- Kode: Memilih Dependency
```java
@Bean
public FooBar fooBar(@Qualifier(value="fooSecond") Foo foo, Bar bar) {
    return new FooBar(foo, bar);
}
```
- Kode: Mengakses Bean
```java
Foo foo = applicationContext.getBean("fooSecond", Foo.class);
Bar bar = applicationContext.getBean(Bar.class);
FooBar fooBar = applicationContext.getBean(FooBar.class);

Assertions.assertSame(foo, fooBar.getFoo());
Assertions.assertSame(Bar, fooBar.getBar());
```