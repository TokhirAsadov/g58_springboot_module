package uz.pdp.springboot_module.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springboot_module.service.BookService;
import uz.pdp.springboot_module.utils.Constants;

@RestController
@RequiredArgsConstructor
@RequestMapping(BookController.BASE_URL)
public class BookController {
    public static final String BASE_URL = Constants.BASE_URL+"/books";

    private final BookService bookService;


}
