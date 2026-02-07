package uz.pdp.springboot_module.entity_domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {
    private Integer id;
    private String name;
    private String author;
}
