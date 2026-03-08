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
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@OpenAPIDefinition(
        info = @Info(
                title = "Working with .properties files - G58 | OpenAPI Specification | Swagger",
                version = "v1.0",
                description = "lesson-7.2",
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
public class SpringbootModuleApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringbootModuleApplication.class, args);
    }

//	@Bean
//	public CommandLineRunner run(){
//		return args -> {
//			productRepository.saveAll(
//					List.of(
//							new Product("Product 1", 100),
//							new Product( "Product 2", 200),
//							new Product("Product 3", 300)
//					)
//			);
//		};
//	}

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
