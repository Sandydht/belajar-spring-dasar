# Scope
- Scope merupakan sebuah strategy untuk membuat sebuah objek.
- Secara default strategi objek di Spring adalah singleton (hanya dibuat sekali), dan ketika kita akses akan mengembalikan object yang sama.
- Namun kita juga bisa mengubah scope bean yang kita mau di Spring.
- Untuk mengubah scope sebuah bean, kita bisa tambahkan annotation ``` @Scope(value="namaScope") ```.

# Bean Scope
| Scope       | Keterangan                                            |
| ----------- | ----------------------------------------------------- |
| singleton   | (Default) Hanya dibuat sekali dalam Spring IoC        |
| prototype   | Selalu dibuat object baru setiap kali bean diakses    |
| request     | Dibuat baru per HTTP Request (hanya untuk Web App)    |
| session     | Dibuat baru per HTTP Session (hanya untuk Web App)    |
| application | Dibuat baru per ServletContext (hanya untuk Web App)  |
| websocket   | Dibuat baru per WebSocket (hanya untuk WebSocket App) |

- Kode: Scope Prototype
```java
@Bean
@Scope("prototype")
public Foo foo() {
    return new Foo();
}
```
- Kode: Mengakses Bean
```java
Foo foo1 = applicationContext.getBean(Foo.class);
Foo foo2 = applicationContext.getBean(Foo.class);
Foo foo3 = applicationContext.getBean(Foo.class);

Assertions.assertNotSame(foo1, foo2);
Assertions.assertNotSame(foo2, foo3);
Assertions.assertNotSame(foo3, foo1);
```