package uz.pdp.springboot_module.service;

import uz.pdp.springboot_module.payload.BookCreator;
import uz.pdp.springboot_module.payload.BookResponse;

import java.util.List;

public interface BookService {
    void createBook(BookCreator creator);

    List<BookResponse> findAll();
}
