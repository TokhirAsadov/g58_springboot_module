package uz.pdp.springboot_module.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StudentCreator(
        @NotBlank(message = "First name must not be blank")
        @JsonProperty("first_name")
        String firstName,
        @NotBlank(message = "Last name must not be blank")
        @JsonProperty("last_name")
        String lastName,
        @Positive(message = "Age must be positive")
        Integer age,
        @Positive(message = "Birth year must be positive")
        @JsonProperty("birth_year")
        Integer birthYear,
        @NotNull(message = "Group ID must not be null")
        @JsonProperty("group_id")
        Long groupId
) {
}
