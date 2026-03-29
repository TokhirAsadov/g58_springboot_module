package uz.pdp.springboot_module.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    @Async
    public void getMessage() {
        System.out.println("Executing getMessage method in thread: " + Thread.currentThread().getName());
    }
}
