package uz.pdp.springboot_module;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@OpenAPIDefinition(
        info = @Info(
                title = "Task Scheduling (@Schedule, cron - jobs) - G58 | OpenAPI Specification | Swagger",
                version = "v1.0",
                description = "lesson-8.1.TaskScheduling - branch",
                contact = @Contact(
                        name = "Tokhir Asadov",
                        email = "guvalakat1603@gmail.com",
                        url = "https://github.com/TokhirAsadov"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://springdoc.org"),
                termsOfService = "http://swagger.io/terms/"
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring 6 Wiki Documentation", url = "https://springshop.wiki.github.org/docs"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Local server for development and testing"
                )
        }
)
@SpringBootApplication
@ConfigurationPropertiesScan
@EnableScheduling
public class SpringbootModuleApplication {


    public static void main(String[] args) {

        class ClockTask extends TimerTask {

            private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            @Override
            public void run() {
                System.out.print("\r"+"Time is : "+dateFormat.format(new Date()));
            }
        }
        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new ClockTask(), 3000, 10000);

        SpringApplication.run(SpringbootModuleApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
