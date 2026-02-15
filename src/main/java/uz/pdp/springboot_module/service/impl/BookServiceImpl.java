package uz.pdp.springboot_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.springboot_module.entity.Book;
import uz.pdp.springboot_module.payload.BookCreator;
import uz.pdp.springboot_module.payload.BookResponse;
import uz.pdp.springboot_module.repository.BookDTO;
import uz.pdp.springboot_module.repository.BookRepository;
import uz.pdp.springboot_module.repository.GetBookDTO;
import uz.pdp.springboot_module.service.BookService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public BookResponse create(BookCreator creator) {
        Book book = Book.builder()
                .name(creator.name())
                .author(creator.author())
                .year(creator.year())
                .price(creator.price())
                .pages(creator.pages())
                .build();
        Book save = bookRepository.save(book);
        return new BookResponse(
                save.getId(),
                save.getName(),
                save.getAuthor(),
                save.getYear(),
                save.getPrice(),
                save.getPages()
        );
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
//        Optional<Book> optionalBook = bookRepository.findById(id);
//        if (optionalBook.isPresent()) {
//            Book book = optionalBook.get();
//            return book;
//        } else {
//            return null;
//        }
    }

    @Override
    public BookResponse findByName(String name) {
        return bookRepository.findByNameIgnoreCase(name)
                .map(book -> new BookResponse(book.getId(),book.getName(), book.getAuthor(), book.getYear(), book.getPrice(), book.getPages()                ))
                .orElse(null);

//        Optional<Book> optionalBook = bookRepository.findByName(name);
//        if (optionalBook.isPresent()){
//            Book book = optionalBook.get();
//            return new BookResponse(
//                    book.getId(),
//                    book.getName(),
//                    book.getAuthor(),
//                    book.getYear(),
//                    book.getPrice(),
//                    book.getPages()
//            );
//        }
//        return null;
    }

    @Override
    public List<BookResponse> findByParams(String name, Double price) {
        return bookRepository.findAllByNameIgnoreCaseStartsWithAndPriceGreaterThanEqual(name, price)
                .stream()
                .map(book -> new BookResponse(
                        book.getId(),
                        book.getName(),
                        book.getAuthor(),
                        book.getYear(),
                        book.getPrice(),
                        book.getPages()
                )).toList();
    }

    @Override
    public List<BookResponse> findByPriceBetween(Double fromPrice, Double toPrice) {
        return bookRepository.findAllByPriceBetween(fromPrice, toPrice)
                .stream()
                .map(book -> new BookResponse(
                        book.getId(),
                        book.getName(),
                        book.getAuthor(),
                        book.getYear(),
                        book.getPrice(),
                        book.getPages()
                )).toList();
    }

    @Override
    public List<BookResponse> findByYearBetween(Integer fromYear, Integer toYear) {
        return bookRepository.findAllByYearBetween(fromYear, toYear)
                .stream()
                .map(book -> new BookResponse(
                        book.getId(),
                        book.getName(),
                        book.getAuthor(),
                        book.getYear(),
                        book.getPrice(),
                        book.getPages()
                )).toList();
    }

    @Override
    public List<GetBookDTO> getBooksByName(String name) {
        return bookRepository.getBooksByName(name);
    }

    @Override
    public List<BookDTO> getBooksByName2(String name) {
        return bookRepository.getBooksByName2(name);
    }
}
