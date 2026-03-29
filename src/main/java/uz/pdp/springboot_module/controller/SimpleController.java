package uz.pdp.springboot_module.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springboot_module.service.SimpleService;

@Slf4j
@RestController
@RequestMapping("/api/simple")
public class SimpleController {
    private final SimpleService simpleService;

    public SimpleController(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    @GetMapping("/message")
    public String getMessage() {
        simpleService.getMessage();
        return "Message logged successfully!";
    }
}
