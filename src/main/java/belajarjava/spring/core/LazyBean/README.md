# Lazy Bean
- Secara default, bean di Spring akan dibuat ketika aplikasi Spring pertama kali berjalan.
- Oleh karena itu, kadang ketika aplikasi Spring pertama berjalan akan sedikit lambat, hal ini dikarenakan semua bean akan dibuat diawal.
- Namun jika kita mau, kita juga bisa membuat bean menjadi lazy, dimana bean tidak akan dibuat, sampai memang diakses atau dibutuhkan.
- Untuk membuat sebuah bean menjadi lazy, kita bisa tambahkan annotation ``` @Lazy ``` pada bean tersebut.
- Kode: Lazy Bean
```java
@Lazy
@Bean
@DependsOn({ "bar" })
public Foo foo() {
    return new Foo();
}
```