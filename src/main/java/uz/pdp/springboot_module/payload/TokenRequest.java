package uz.pdp.springboot_module.payload;

public record TokenRequest(
        String username,
        String password
) {
}
