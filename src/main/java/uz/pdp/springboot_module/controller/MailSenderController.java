package uz.pdp.springboot_module.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springboot_module.service.MailSernderService;

@Slf4j
@RestController
@RequestMapping("/api/mail")
public class MailSenderController {
    private final MailSernderService mailSernderService;

    public MailSenderController(MailSernderService mailSernderService) {
        this.mailSernderService = mailSernderService;
    }

    @GetMapping("/send-text/{username}")
    public String sendText(@PathVariable String username) {
        mailSernderService.sendText(username);
        return "Send Message Successfully!🎉🎉🎉";
    }

    @GetMapping("/send-html-content/{username}")
    public String sendHtmlContent(@PathVariable String username) {
        mailSernderService.sendHtmlContent(username);
        return "Send Message Successfully!🎉🎉🎉";
    }

    @GetMapping("/send-html-page-v1/{username}")
    public String sendHtmlPageV1(@PathVariable String username) {
        mailSernderService.sendHtmlPageV1(username);
        return "Send Message Successfully!🎉🎉🎉";
    }



    @GetMapping("/send-attachment/{username}")
    public String sendAttachment(@PathVariable String username) {
        mailSernderService.sendAttachment(username);
        return "Send Message Successfully!🎉🎉🎉";
    }

    @GetMapping("/send-html-page-with-image-v1/{username}")
    public String sendHtmlPageWithImageV1(@PathVariable String username) {
        mailSernderService.sendHtmlPageWithImageV1(username);
        return "Send Message Successfully!🎉🎉🎉";
    }

    @GetMapping("/send-html-page-with-image-v2/{username}")
    public String sendHtmlPageWithImageV2(@PathVariable String username) {
        mailSernderService.sendHtmlPageWithImageV2(username);
        return "Send Message Successfully!🎉🎉🎉";
    }
}
