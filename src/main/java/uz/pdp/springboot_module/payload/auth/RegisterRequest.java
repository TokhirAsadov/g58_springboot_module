package uz.pdp.springboot_module.payload.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record RegisterRequest(
        String username,
        String password,
        String fullName,
        @JsonProperty("roles_ids")
        List<Integer> rolesIds
) {
}
