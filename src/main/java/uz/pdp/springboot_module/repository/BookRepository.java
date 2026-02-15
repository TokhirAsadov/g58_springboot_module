package uz.pdp.springboot_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springboot_module.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
