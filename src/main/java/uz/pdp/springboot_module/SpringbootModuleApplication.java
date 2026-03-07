package uz.pdp.springboot_module;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uz.pdp.springboot_module.entity.Product;
import uz.pdp.springboot_module.repository.ProductRepository;

import java.util.List;

@OpenAPIDefinition(
		info = @Info(
				title = "Product API - G58 | OpenAPI Specification | Swagger",
				version = "v1.0",
				description = "API for managing products",
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
						description = "Dev server"
				),
				@Server(
						url = "http://localhost:9090",
						description = "Test server"
				),
				@Server(
						url = "http://localhost:7070",
						description = "Prod server"
				)

		}
)
@SpringBootApplication
@RequiredArgsConstructor
public class SpringbootModuleApplication {

	private final ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootModuleApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(){
		return args -> {
			productRepository.saveAll(
					List.of(
							new Product(null, "Product 1", 100),
							new Product(null, "Product 2", 200),
							new Product(null, "Product 3", 300)
					)
			);
		};
	}
}
