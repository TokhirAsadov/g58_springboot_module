package uz.pdp.springboot_module.service;

import uz.pdp.springboot_module.entity.Book;
import uz.pdp.springboot_module.payload.book.BookCreator;
import uz.pdp.springboot_module.payload.book.BookResponse;
import uz.pdp.springboot_module.payload.book.BookDTO;
import uz.pdp.springboot_module.payload.book.GetBookDTO;

import java.util.List;

public interface BookService {
    BookResponse create(BookCreator creator);

    List<Book> findAll();

    Book findById(Long id);

    BookResponse findByName(String name);

    List<BookResponse> findByParams(String name, Double price);

    List<BookResponse> findByPriceBetween(Double fromPrice, Double toPrice);

    List<BookResponse> findByYearBetween(Integer fromYear, Integer toYear);

    List<GetBookDTO> getBooksByName(String name);

    List<BookDTO> getBooksByName2(String name);
}
