package uz.pdp.springboot_module.service.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uz.pdp.springboot_module.payload.BookCreator;
import uz.pdp.springboot_module.payload.BookResponse;
import uz.pdp.springboot_module.service.BookService;

import java.util.Collections;
import java.util.List;

@Service // = @Component
public class BookServiceImpl implements BookService {

    private final JdbcTemplate jdbcTemplate;

    public BookServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createBook(BookCreator creator) {
        jdbcTemplate.update("insert into books(name, author) values (?, ?)", creator.name(), creator.author());
        System.out.println("Book created successfully 🎉🎉🎉" );
    }

    @Override
    public List<BookResponse> findAll() {
        List<BookResponse> books = jdbcTemplate.query("select * from books;", (rs, rowNum) -> new BookResponse(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("author")
        ));
        return books.isEmpty() ? Collections.emptyList() : books;
    }
}
