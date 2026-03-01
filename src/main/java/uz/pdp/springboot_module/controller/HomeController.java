package uz.pdp.springboot_module.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String welcome() {
        return "Welcome to the Home Page!";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'MANAGER')")
    public String user() {
        return "Welcome USER Page!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "Welcome ADMIN Page!";
    }

    @GetMapping("/manager")
    @PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
    public String manager() {
        return "Welcome MANAGER Page!";
    }

    @PostMapping("/test")
    public String test() {
        return "Test POST endpoint accessed successfully!";
    }

}
