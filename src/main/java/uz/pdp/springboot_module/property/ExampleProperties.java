package uz.pdp.springboot_module.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "example")
public record ExampleProperties(
        String string,
        List<String> languages,
        List<String> languages2,
        Map<String, String> numbers
) {
}
