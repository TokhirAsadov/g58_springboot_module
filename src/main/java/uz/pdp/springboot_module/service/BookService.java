package uz.pdp.springboot_module.service;

import uz.pdp.springboot_module.entity.Book;
import uz.pdp.springboot_module.payload.BookCreator;
import uz.pdp.springboot_module.payload.BookResponse;

import java.util.List;

public interface BookService {
    BookResponse create(BookCreator creator);

    List<Book> findAll();

    Book findById(Long id);

    BookResponse findByName(String name);

    List<BookResponse> findByParams(String name, Double price);

    List<BookResponse> findByPriceBetween(Double fromPrice, Double toPrice);
}
