package uz.pdp.springboot_module.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class SimpleService {

    @Async
    public void sendMessage() {
        log.info("sendMessage is starting. Time: {}", new Date());

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("sendMessage is sent. Time: {}", new Date());
        throw new RuntimeException("Xatolik sodir buldi............");
    }

}
