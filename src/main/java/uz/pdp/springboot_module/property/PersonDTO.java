package uz.pdp.springboot_module.property;

import java.util.UUID;

public record PersonDTO(
        UUID id,
        String firstName,
        String lastName,
        String fullName,
        Integer age
) {
}
