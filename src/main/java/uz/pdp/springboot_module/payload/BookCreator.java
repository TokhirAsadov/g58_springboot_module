package uz.pdp.springboot_module.payload;

public record BookCreator(
        String name,
        String author,
        Integer year,
        Double price,
        Integer pages
) {
}
