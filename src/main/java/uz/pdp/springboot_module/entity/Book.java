package uz.pdp.springboot_module.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.springboot_module.payload.book.BookDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "books")
@SqlResultSetMapping(
        name = "BookDTOMapping",
        classes = @ConstructorResult(
                targetClass = BookDTO.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "author", type = String.class),
                }
        )
)
@NamedNativeQuery(
        name = "Book.getBooksByName",
        query = "select b.id, b.name, b.author from books b where b.name ilike concat('%', :name, '%')",
        resultSetMapping = "BookDTOMapping"
)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    private String author;
    private Integer year;
    private Double price;
    private Integer pages;
}
