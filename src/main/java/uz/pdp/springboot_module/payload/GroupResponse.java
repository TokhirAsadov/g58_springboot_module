package uz.pdp.springboot_module.payload;

import lombok.Builder;

@Builder
public record GroupResponse(
        Integer id,
        String name,
        Integer level
) {
}
