package uz.pdp.springboot_module.payload.student;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import uz.pdp.springboot_module.payload.group.GroupResponse;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record StudentResponse(
        Long id,
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        Integer age,
        @JsonProperty("birth_year")
        Integer birthYear,
        GroupResponse group
) {
}
