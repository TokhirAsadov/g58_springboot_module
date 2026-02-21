package uz.pdp.springboot_module.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_module.entity.Book;
import uz.pdp.springboot_module.payload.BookCreator;
import uz.pdp.springboot_module.payload.BookResponse;
import uz.pdp.springboot_module.payload.BookDTO;
import uz.pdp.springboot_module.payload.GetBookDTO;
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

    @GetMapping("/findByName/{name}")
    public BookResponse findByName(@PathVariable String name) {
        return bookService.findByName(name);
    }

    @GetMapping("/findByParams")
    public List<BookResponse> findByParams(
            @RequestParam String name,
            @RequestParam Double price
    ) {
        return bookService.findByParams(name, price);
    }

    @GetMapping("/findByPriceBetween")
    public List<BookResponse> findByPriceBetween(
            @RequestParam Double fromPrice,
            @RequestParam Double toPrice
    ) {
        return bookService.findByPriceBetween(fromPrice, toPrice);
    }

    @GetMapping("/findByYearBetween")
    public List<BookResponse> findByYearBetween(
            @RequestParam Integer fromYear,
            @RequestParam Integer toYear
    ) {
        return bookService.findByYearBetween(fromYear, toYear);
    }
    @GetMapping("/getBooksByName")
    public List<GetBookDTO> getBooksByName(
            @RequestParam String name
    ) {
        return bookService.getBooksByName(name);
    }

    @GetMapping("/getBooksByName2")
    public List<BookDTO> getBooksByName2(
            @RequestParam String name
    ) {
        return bookService.getBooksByName2(name);
    }
}
