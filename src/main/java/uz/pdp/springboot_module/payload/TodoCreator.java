package uz.pdp.springboot_module.payload;

public record TodoCreator(
    String title,
    Integer priority
) {
}
