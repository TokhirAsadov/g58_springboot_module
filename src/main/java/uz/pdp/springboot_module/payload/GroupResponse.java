package uz.pdp.springboot_module.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record GroupResponse(
        Long id,
        @JsonProperty("group_name")
        String name,
        @JsonProperty("group_level")
        Integer level
) {
}
