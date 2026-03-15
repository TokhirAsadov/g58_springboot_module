package uz.pdp.springboot_module.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springboot_module.service.SimpleService;

@RestController
@RequestMapping("/example")
public class ExampleController {

    private final SimpleService service;

    public ExampleController(SimpleService service) {
        this.service = service;
    }

    @GetMapping("/sendMessage")
    public String sendMessage(){
        service.sendMessage();
        return "Xabar jo`natildi";
    }
}
