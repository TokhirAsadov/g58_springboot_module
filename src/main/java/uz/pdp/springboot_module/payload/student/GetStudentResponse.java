package uz.pdp.springboot_module.payload.student;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface GetStudentResponse {
    Long getId();

    @JsonProperty("first_name")
    String getFirstName();

    @JsonProperty("last_name")
    String getLastName();

    Integer getAge();

    @JsonProperty("birth_year")
    Integer getBirthYear();
}
