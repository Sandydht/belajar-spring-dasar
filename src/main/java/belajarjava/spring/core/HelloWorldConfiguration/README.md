# Application Context
- ApplicationContext adalah sebuah interface representasi container IoC di Spring.
- ApplicationContext adalah inti dari Spring Framework.
- ApplicationContext banyak sekali implementasinnya, secara garis besar dibagi menjadi 2 jenis implementasi yaitu XML dan Annotation.
- Pada versi Spring 3, XML masih menjadi pilihan utama, namun sekarang sudah banyak orang yang beralih dari XML ke Annotation, bahkan Spring Boot pun merekomendasikan menggunakan Annotation untuk membuat aplikasi Spring.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationContext.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationContext.html)

# Configuration
- Untuk membuat ApplicationContext menggunakan Annotation, pertama kita perlu membuat Configuration Class.
- Configuration Class adalah sebuah class yang terdapat Annotation ``` @Configuration ```.
- Kode: HelloWorldConfiguration
```java
@Configuration
public class HelloWorldConfiguration {

}
```

# Membuat Application Context
- Selanjutnya setelah membuat Configuration Class, kita bisa menggunakan class ``` AnnotationConfigApplicationContext ``` untuk membuat ApplicationContext.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html).
- Kode: Membuat ApplicationContext

```java
ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
Assertions.assertNotNull(context);
```