package uz.pdp.springboot_module.payload.group;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GroupCreator(
        @NotBlank(message = "Group name must not be blank")
        String name,
        @Positive(message = "Level must be a positive integer")
        Integer level
) {
}
