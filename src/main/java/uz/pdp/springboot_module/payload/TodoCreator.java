package uz.pdp.springboot_module.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record TodoCreator(
        @NotBlank
        @Size(min = 3, max = 100)
        String title,
        @NotNull
        Integer priority
) {
}
