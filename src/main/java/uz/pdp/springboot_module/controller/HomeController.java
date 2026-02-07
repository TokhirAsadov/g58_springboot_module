package uz.pdp.springboot_module.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import uz.pdp.springboot_module.payload.BookCreator;
import uz.pdp.springboot_module.payload.BookResponse;
import uz.pdp.springboot_module.property.MailingProperty;
import uz.pdp.springboot_module.service.BookService;

import java.util.List;

@Controller
public class HomeController {

    @Value("${g58.message}")
    private String message;

    private final MailingProperty mailingProperty;
    private final BookService bookService;

    public HomeController(MailingProperty mailingProperty, BookService bookService) {
        this.mailingProperty = mailingProperty;
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String home(Model model) {
//        model.addAttribute("message", message);
//        System.out.println(mailingProperty);
        List<BookResponse> books = bookService.findAll();
        model.addAttribute("books", books);
        return "home";
    }

    @GetMapping("/create-book")
    public String createBookGetPage() {
        return "create-book";
    }

    @PostMapping("/create-book")
    public String createBook(@ModelAttribute BookCreator creator) {
        bookService.createBook(creator);
        return "redirect:/";
    }
}
