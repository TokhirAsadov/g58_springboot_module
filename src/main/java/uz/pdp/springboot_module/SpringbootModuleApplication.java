package uz.pdp.springboot_module;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uz.pdp.springboot_module.entity.Product;
import uz.pdp.springboot_module.repository.ProductRepository;

import java.util.List;

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
