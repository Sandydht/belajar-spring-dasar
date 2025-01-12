# Bean
- Saat sebuah objek kita masukkan ke dalam Spring container IoC, maka kita sebut objek itu adalah Bean.
- Secara default bean merupakan singleton, artinya jika kita mengakses bean yang sama, maka dia akan mengembalikan objek yang sama. Kita juga bisa mengubahnya jika tidak ingin singleton.

# Membuat Bean
- Untuk membuat bean, kita bisa membuat sebuah method di dalam Configuration Class.
- Selanjutnya nama method tersebut akan menjadi nama bean-nya, dan return objeknya menjadi objek bean-nya.
- Method tersebut perlu kita tambahkan annotation ``` @Bean ``` untuk menandakan bahwa itu adalah bean.
- Secara otomatis Spring akan mengeksekusi method tersebut dan return value-nya akan dijadikan objek bean secara otomatis, dan disimpan di container IoC.
- Kode: Membuat Bean
```java
@Configuration
public class BeanConfiguration {
    @Bean
    public Foo foo() {
        Foo foo = new Foo();
        return foo;
    }
}
```

# Mengakses Bean
- Setelah kita membuat bean, secara otomatis semua objek akan di manage oleh ApplicationContext.
- Untuk mengakses bean, kita bisa menggunakan method ``` getBean() ``` milik ApplicationContext.
- Kode: Mengakses Bean
```java
Foo foo1 = applicationContext.getBean(Foo.class);
Foo foo2 = applicationContext.getBean(Foo.class);

Assertions.assertSame(foo1, foo2);
```
