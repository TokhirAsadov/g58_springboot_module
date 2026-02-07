package uz.pdp.springboot_module.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uz.pdp.springboot_module.property.MailingProperty;

@Controller
public class HomeController {

    @Value("${g58.message}")
    private String message;

    private final MailingProperty mailingProperty;

    public HomeController(MailingProperty mailingProperty) {
        this.mailingProperty = mailingProperty;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", message);
        System.out.println(mailingProperty);
        return "home";
    }
}
