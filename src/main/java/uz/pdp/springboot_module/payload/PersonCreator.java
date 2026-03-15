package uz.pdp.springboot_module.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PersonCreator(
        @JsonProperty("person_dto")
        PersonDTO personDTO,
        @JsonProperty("address_dto")
        AddressDTO addressDTO,
        @JsonProperty("passport_dto")
        PassportDTO passportDTO
) {
}
