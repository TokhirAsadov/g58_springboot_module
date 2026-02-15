package uz.pdp.springboot_module.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_module.entity.Book;
import uz.pdp.springboot_module.entity.Post;
import uz.pdp.springboot_module.payload.BookCreator;
import uz.pdp.springboot_module.payload.BookResponse;
import uz.pdp.springboot_module.service.BookService;
import uz.pdp.springboot_module.utils.Constants;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BookController.BASE_URL)
public class BookController {
    public static final String BASE_URL = Constants.BASE_URL+"/books";

    private final BookService bookService;


    // /create
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse create(@RequestBody BookCreator creator) {
        return bookService.create(creator);
    }

    // /findAll
    @GetMapping("/findAll")
    public List<Book> findAll() {
        return bookService.findAll();
    }
    // /findById/{id}

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable Long id) {
        return bookService.findById(id);
    }
}
