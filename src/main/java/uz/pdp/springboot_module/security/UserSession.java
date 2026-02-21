package uz.pdp.springboot_module.security;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class UserSession {

    public Long getUserId() {
        return new Random().nextLong(10,100);
    }

}
