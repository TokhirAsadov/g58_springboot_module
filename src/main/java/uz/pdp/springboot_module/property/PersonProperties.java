package uz.pdp.springboot_module.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "person")
public record PersonProperties(
        Integer id,
        @DefaultValue("ESHMAT")
        String firstName,
        String lastName,
        String fullName,
        Integer age
) {
}
