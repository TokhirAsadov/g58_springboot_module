package uz.pdp.springboot_module.payload;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductResponse(
        Integer id,
        String name,
        Integer price
) {
}
