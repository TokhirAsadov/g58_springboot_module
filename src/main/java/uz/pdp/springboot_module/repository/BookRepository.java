package uz.pdp.springboot_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.springboot_module.entity.Book;
import uz.pdp.springboot_module.payload.book.BookDTO;
import uz.pdp.springboot_module.payload.book.GetBookDTO;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByName(String name);

    Optional<Book> findByNameIgnoreCase(String name);

    List<Book> findAllByNameIgnoreCaseStartsWithAndPriceGreaterThanEqual(String name, Double price);

    List<Book> findAllByPriceBetween(Double fromPrice, Double toPrice);

    List<Book> findAllByYearBetween(Integer fromYear, Integer toYear);

    @Query("select new uz.pdp.springboot_module.payload.book.BookDTO(b.id, b.name,b.author) from Book b where b.name ilike %:name% ")
//    @Query(value = "select b.id, b.name, b.author from books b where b.name ilike concat('%', :name, '%')", nativeQuery = true)
//    @Query(name = "Book.getBooksByName")
    List<GetBookDTO> getBooksByName(@Param("name") String name);

    @Query(name = "Book.getBooksByName")
    List<BookDTO> getBooksByName2(@Param("name") String name);
}
