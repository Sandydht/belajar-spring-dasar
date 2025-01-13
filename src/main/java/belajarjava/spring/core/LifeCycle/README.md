# Life Cycle
- Spring Container memiliki alur hidup, kita bisa berinteraksi alur hidup tersebut.
- Saat pertama kali Spring berjalan dan sudah selesai membuat bean, Spring akan memberitahu bean tersebut bahwa bean tersebut sudah siap, artinya semua dependencies sudah dimasukkan.
- Dan ketika aplikasi Spring akan mati, Spring juga akan memberitahu semua bean bahwa bean tersebut akan dihancurkan.

# Life Cycle Callback
- Secara default, bean tidak bisa tahu alur hidup Spring ketika selesai membuat bean dan ketika akan menghancurkan bean.
- Jika kita tertarik untuk bereaksi ketika alur hidup Spring terjadi, maka kita bisa implements interface InitializingBean dan DisposableBean.
- InitializingBean digunakan jika kita ingin bereaksi ketika Spring selesai membuat bean.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/InitializingBean.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/InitializingBean.html).
- DisposableBean digunakan jika kita ingin bereaksi ketika Spring akan menghancurkan bean.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/DisposableBean.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/DisposableBean.html)
- Kode: Connection Class
```java
@Slf4j
public class Connection implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Connection ready to be used");
    }

    @Override
    public void destroy() throws Exception {
        log.info("Connection closed");
    }
}
```
- Kode: Life Cycle Configuration
```java
@Configuration
public class LifeCycleConfiguration {
    @Bean
    public Connection connection() {
        return new Connection();
    }
}
```
- Kode: Mengakses Connection
```java
ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
Connection connection = context.getBean(Connection.class);
context.close();
```