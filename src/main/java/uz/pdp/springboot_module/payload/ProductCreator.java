package uz.pdp.springboot_module.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Schema(description = "Product yaratish uchun kerak bo`lgan ma`lumotlar")
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductCreator(
        @Schema(description = "Product nomi", example = "Laptop")
        @NotBlank(message = "Product name bo`sh bo`lmasligi kerak")
        String name,

        @Schema(description = "Product narxi", example = "1500", minimum = "1", defaultValue = "100")
        @Positive
        Integer price
) {
}
