package uz.pdp.springboot_module.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.pdp.springboot_module.entity.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

//    @Query("select p from Post p") // JPQL
//    @Query(nativeQuery = true, value = "select * from posts;") // native SQL query
//    @Query(name = "Post.getAllPosts") // named query
//    @Query(name = "Post.getAllPostsNative") // named native query
    @Query(
            nativeQuery = true,
            value = "select * from posts",
            countQuery = "select count(*) from posts"
    )
    Page<Post> getAllPosts(Pageable pageable);

    @Query("select p from Post p where p.userId = ?1") // JPQL
    List<Post> getPostsByUserId(Integer userId, Sort sort);

}
