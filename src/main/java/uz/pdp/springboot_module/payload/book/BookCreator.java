package uz.pdp.springboot_module.payload.book;

public record BookCreator(
        String name,
        String author,
        Integer year,
        Double price,
        Integer pages
) {
}
