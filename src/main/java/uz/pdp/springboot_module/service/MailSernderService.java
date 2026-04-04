package uz.pdp.springboot_module.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailSernderService {

//    private static final Logger log = LoggerFactory.getLogger(MailSernderService.class);

    private final JavaMailSender javaMailSender;
    private final Configuration configuration;

    private final LogService logService;

    @Async
    public void sendText(String username) {

        logService.logInfo("logs/sms/sendText", "sendText ::::: %s@gmail.com | id: %s".formatted(username, UUID.randomUUID()));

//        for (int i = 0; i < 2000; i++) {
//            if (new Random().nextBoolean()){
//                log.warn("sendText ::::: {}@gmail.com | id: {}", username, i);
//            } else {
//                log.error("sendText ::::: error | id: {}", i);
//            }
//        }

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            mimeMessage.setSubject("Hello, " + username + "!");
            mimeMessage.setText("G58 - Spring Boot Module - Lesson 8.3 - Mailing and FreeMaker");

            mimeMessage.setRecipients(MimeMessage.RecipientType.TO, username + "@gmail.com");
            mimeMessage.setFrom("from@gmail.com");

            javaMailSender.send(mimeMessage);
            System.out.println("Email sent successfully to " + username + "@gmail.com ✅✅✅");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void sendHtmlContent(String username) {
        logService.logInfo("logs/sms/sendHtmlContent", "sendText ::::: %s@gmail.com | id: %s".formatted(username, UUID.randomUUID()));
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            mimeMessage.setSubject("Hello, " + username + "!");
            mimeMessage.setContent("<h1>Assalamu alaykum, <span style=\"color:green;\">" + username + "</span></h1>", "text/html");

            mimeMessage.setRecipients(MimeMessage.RecipientType.TO, username + "@gmail.com");
            mimeMessage.setFrom("from@gmail.com");

            javaMailSender.send(mimeMessage);
            System.out.println("Email sent successfully to " + username + "@gmail.com ✅✅✅");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void sendHtmlPageV1(String username) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            mimeMessage.setSubject("Hello, " + username + "!");

            Path htmlFilePath = Path.of("src/main/resources/welcome.html");
            String htmlFileFormatted = Files.readString(htmlFilePath).formatted(username);
            mimeMessage.setContent(htmlFileFormatted, "text/html");

            mimeMessage.setRecipients(MimeMessage.RecipientType.TO, username + "@gmail.com");
            mimeMessage.setFrom("from@gmail.com");

            javaMailSender.send(mimeMessage);
            System.out.println("Email sent successfully to " + username + "@gmail.com ✅✅✅");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Async
    public void sendAttachment(String username) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setSubject("Hello, " + username + "!");

            Path htmlFilePath = Path.of("src/main/resources/welcome.html");
            String htmlFileFormatted = Files.readString(htmlFilePath).formatted(username);
            helper.setText(htmlFileFormatted, true);

            helper.setTo(username + "@gmail.com");
            helper.setFrom("from@gmail.com");

            Path imagePath = Path.of("src/main/resources/java.png");
            Path pdfPath = Path.of("src/main/resources/Logging.pdf");
            FileSystemResource imageSystemResource = new FileSystemResource(imagePath);
            FileSystemResource pdfSystemResource = new FileSystemResource(pdfPath);

            helper.addAttachment("java.png", imageSystemResource);
            helper.addAttachment("9.9 Logging.pdf", pdfSystemResource);

            javaMailSender.send(mimeMessage);
            System.out.println("Email sent successfully to " + username + "@gmail.com ✅✅✅");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Async
    public void sendHtmlPageWithImageV1(String username) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            mimeMessage.setSubject("Hello, " + username + "!");

            Path html = Path.of("src/main/resources/image.html");
            Path imageUrl = Path.of("src/main/resources/java.png");
            Base64.Encoder encoder = Base64.getEncoder();
            String imageBase64 = encoder.encodeToString(Files.readAllBytes(imageUrl));

            String htmlFileFormatted = Files.readString(html).formatted(imageBase64);
            mimeMessage.setContent(htmlFileFormatted, "text/html");

            mimeMessage.setRecipients(MimeMessage.RecipientType.TO, username + "@gmail.com");
            mimeMessage.setFrom("from@gmail.com");

            javaMailSender.send(mimeMessage);
            System.out.println("Email sent successfully to " + username + "@gmail.com ✅✅✅");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Async
    public void sendHtmlPageWithImageV2(String username) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setSubject("Hello, " + username + "!");

            helper.setTo(username + "@gmail.com");
            helper.setFrom("from@gmail.com");

            Path html = Path.of("src/main/resources/image2.html");
            Path imageUrl = Path.of("src/main/resources/java.png");

            String htmlContent = Files.readString(html);

            helper.setText(htmlContent, true);
            helper.addInline("image_id", new FileSystemResource(imageUrl));

            javaMailSender.send(mimeMessage);
            System.out.println("Email sent successfully to " + username + "@gmail.com ✅✅✅");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Async
    public void sendHtmlPageWithFreeMaker(String username) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setSubject("Hello, " + username + "!");
            helper.setTo(username + "@gmail.com");
            helper.setFrom("from@gmail.com");

            Template template = configuration.getTemplate("activate_account.ftlh");
            Base64.Encoder encoder = Base64.getEncoder();
            String token = encoder.encodeToString(username.getBytes());
            Map<String, String> data = Map.of("username", username, "token", token);
            String htmlContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, data);

            helper.setText(htmlContent, true);
            javaMailSender.send(mimeMessage);

            System.out.println("Email sent successfully to " + username + "@gmail.com ✅✅✅");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }


}
