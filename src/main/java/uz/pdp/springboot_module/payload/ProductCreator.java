package uz.pdp.springboot_module.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductCreator(
        @NotBlank(message = "Product name bo`sh bo`lmasligi kerak")
        String name,
        @Positive
        Integer price
) {
}
