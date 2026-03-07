package uz.pdp.springboot_module;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import uz.pdp.springboot_module.entity.Product;
import uz.pdp.springboot_module.repository.ProductRepository;

import java.util.List;

//@OpenAPIDefinition(
//		info = @Info(
//				title = "Product API - G58 | OpenAPI Specification | Swagger",
//				version = "v1.0",
//				description = "API for managing products",
//				contact = @Contact(
//						name = "Tokhir Asadov",
//						email = "guvalakat1603@gmail.com",
//						url = "https://github.com/TokhirAsadov"
//				),
//				license = @License(
//						name = "Apache 2.0",
//						url = "https://springdoc.org"),
//				termsOfService = "http://swagger.io/terms/"
//		),
//		externalDocs = @ExternalDocumentation(
//				description = "Spring 6 Wiki Documentation", url = "https://springshop.wiki.github.org/docs"
//		),
//		servers = {
//				@Server(
//						url = "http://localhost:8080",
//						description = "Dev server"
//				),
//				@Server(
//						url = "http://localhost:9090",
//						description = "Test server"
//				),
//				@Server(
//						url = "http://localhost:7070",
//						description = "Prod server"
//				)
//
//		}
//)
@SpringBootApplication
public class SpringbootModuleApplication {

	private final ProductRepository productRepository;

    public SpringbootModuleApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(SpringbootModuleApplication.class, args);
	}

	@Bean
	public OpenAPI springOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Spring 6 Swagger 2 Annotation Example")
						.description("Spring 6 Swagger Simple Application")
						.version("v1.0")
						.contact(new Contact()
								.name("Tokhir Asadov")
								.email("guvalakat1603@gmail.com")
								.url("https://github.com/TokhirAsadov"))
						.license(new License()
								.name("Apache 2.0")
								.url("http://springdoc.org"))
						.termsOfService("http://swagger.io/terms/"))
				.externalDocs(new ExternalDocumentation()
						.description("SpringShop Wiki Documentation")
						.url("https://springshop.wiki.github.org/docs"))
				.servers(List.of(
						new Server()
								.url("http://localhost:8080")
								.description("DEV server"),
						new Server()
								.url("http://localhost:9090")
								.description("TEST server"),
						new Server()
								.url("http://localhost:7070")
								.description("PROD server")
				));
	}

	@Bean
	public CommandLineRunner run(){
		return args -> {
			productRepository.saveAll(
					List.of(
							new Product("Product 1", 100),
							new Product( "Product 2", 200),
							new Product("Product 3", 300)
					)
			);
		};
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
