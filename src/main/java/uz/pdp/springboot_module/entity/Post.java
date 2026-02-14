package uz.pdp.springboot_module.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "posts")
@NamedQueries(
        @NamedQuery(
                name = "Post.getAllPosts",
                query = "select p from Post p"
        )
)
@NamedNativeQueries(
        @NamedNativeQuery(
                name = "Post.getAllPostsNative",
                query = "select * from posts",
                resultClass = Post.class
        )
)

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;
    private String title;
    private String body;
}
