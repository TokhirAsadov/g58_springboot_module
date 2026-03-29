package uz.pdp.springboot_module.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class SimpleService {

//    @Scheduled(fixedDelay = 3000)
//    public void fixedDelay() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        log.info("Time: {}", dateFormat.format(new Date()));
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Scheduled(fixedRate = 3, timeUnit = TimeUnit.SECONDS)
//    public void fixedRate() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        log.info("Time: {}", dateFormat.format(new Date()));
//
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Scheduled(cron = "* * * * * *")
    public void fixedRate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("Time: {}", dateFormat.format(new Date()));
    }
}
