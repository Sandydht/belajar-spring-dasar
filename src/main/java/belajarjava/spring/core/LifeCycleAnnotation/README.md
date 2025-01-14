# Life Cycle Annotation
- Selain menggunakan interface InitializingBean dan DisposableBean, kita juga bisa menggunakan annotation untuk mendaftarkan callback method untuk lifecycle.
- Pada annotation @Bean, terdapat method initMethod() dan destoyMethod().
- initMethod() digunakan untuk meregistrasikan method yang akan dipanggil ketika bean selesai dibuat.
- destroyMethod() digunakan untuk meregistrasikan method yang akan dipanggil ketika bean akan dihancurkan.
- Methodnya harus tanpa parameter, dan return value nya tidak akan dipedulikan, jadi sebaiknya gunakan void saja.
- Kode: Server Class
```java
@Slf4j
public class Server {
    public void start() {
        log.info("Start server");
    }
    
    public void stop() {
        log.info("Stop server");
    }
}
```
- Kode: Server Configuration
```java
import org.springframework.context.annotation.Bean;

@Bean(initMethod = "start", destroyMethod = "stop")
public Server server() {
    return new Server();
}
```
- Kode: Mengakses Server
```java
ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ServerConfiguration.class);
context.registerShutdownHook();
Server server = context.getBean(Server.class);
```

# @PostConstruct dan @PreDestroy
- Selain menggunakan annotation ``` @Bean ```, untuk menandai sebuah method adalah init method dan destroy method, kita juga bisa menggunakan annotation pada method nya secara langsung.
- Ini bisa digunakan untuk menghindari kita lupa menyebutkan init dan destroy method ketika membuat ``` @Bean ```.
- ``` @PostConstruct ``` merupakan method yang ditandai harus dipanggil ketika bean selesai dibuat.
- ``` @PreDestroy ``` merupakan method yang ditandai harus dipanggil ketika bean akan dihancurkan.
- Jika sudah menggunakan annotation ini, kita tidak perlu lagi menyebutkan nya di ``` @Bean ```.
- Kode: Server Class
```java
@Slf4j
public class Server {
    @PostConstruct
    public void start() {
        log.info("Start server");
    }

    @PreDestroy
    public void stop() {
        log.info("Stop server");
    }
}
```