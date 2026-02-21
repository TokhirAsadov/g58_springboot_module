package uz.pdp.springboot_module.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record GroupCreator(
        @NotBlank(message = "Group name must not be blank")
        String name,
        @Positive(message = "Level must be a positive integer")
        Integer level
) {
}
