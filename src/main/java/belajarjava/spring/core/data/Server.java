package belajarjava.spring.core.data;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Server {
    public void start() {
        log.info("Start server");
    }

    public void stop() {
        log.info("Stop server");
    }
}
