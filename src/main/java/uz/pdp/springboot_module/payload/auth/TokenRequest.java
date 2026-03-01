package uz.pdp.springboot_module.payload.auth;

public record TokenRequest(
        String username,
        String password
) {
}
