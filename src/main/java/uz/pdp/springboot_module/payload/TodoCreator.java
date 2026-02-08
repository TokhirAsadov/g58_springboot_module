package uz.pdp.springboot_module.payload;

import jakarta.validation.constraints.*;

public record TodoCreator(
        @NotBlank
        @Size(min = 3, max = 100)
        String title,
        @NotNull
        @Min(1)
        Integer priority
) {
}
