# Singleton
- Singleton adalah salah satu design pattern untuk membuat objek, dimana sebuah objek hanya dibuat satu kali saja.
- Dan ketika kita membutuhkan objek tersebut, kita hanya akan menggunakan objek yang sama.
- [https://refactoring.guru/design-patterns/singleton](https://refactoring.guru/design-patterns/singleton).

# Membuat Singleton di Java
- Ada banyak cara membuat singleton objek di Java.
- Cara yang paling sering digunakan adalah membuat class yang berisikan static method untuk membuat objek dirinya sendiri.
- Selanjutnya constructor pada class tersebut di buat private agar tidak bisa diakses dari luar.
- Sehingga user terpaksa menggunakan method static tersebut ketika ingin menggunakan objeknya.
- Kode: Singleton Class
```java
public class Database {
    private static Database database;
    
    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        
        return database;
    }
}

Database database1 = Database.getInstance();
Database database2 = Database.getInstance();

Assertions.assertSame(database1, database2);
```