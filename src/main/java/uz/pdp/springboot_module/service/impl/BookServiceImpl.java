package uz.pdp.springboot_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.springboot_module.entity.Book;
import uz.pdp.springboot_module.payload.BookCreator;
import uz.pdp.springboot_module.payload.BookResponse;
import uz.pdp.springboot_module.repository.BookRepository;
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
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            return book;
        } else {
            return null;
        }
    }
}
