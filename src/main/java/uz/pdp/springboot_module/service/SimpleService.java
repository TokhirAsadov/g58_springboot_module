package uz.pdp.springboot_module.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class SimpleService {

    //public static final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    @Async
    public void sendMessage() {
        System.out.printf("sendMessage is starting. Time: %s%n", new Date());

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("sendMessage is sent. Time: %s%n", new Date());

        //executorService.execute(runnable);
    }

}
