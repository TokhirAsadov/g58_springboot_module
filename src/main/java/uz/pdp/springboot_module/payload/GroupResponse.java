package uz.pdp.springboot_module.payload;

import lombok.Builder;

@Builder
public record GroupResponse(
        Long id,
        String name,
        Integer level
) {
}
