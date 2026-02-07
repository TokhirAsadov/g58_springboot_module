package uz.pdp.springboot_module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import uz.pdp.springboot_module.property.MailingProperty;

@SpringBootApplication
@EnableConfigurationProperties(
		{MailingProperty.class}
)
public class SpringbootModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootModuleApplication.class, args);
	}

}
