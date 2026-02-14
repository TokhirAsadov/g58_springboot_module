package uz.pdp.springboot_module.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.springboot_module.entity.Post;

@Repository
@RequiredArgsConstructor
public class CustomRepository {
    private final EntityManager em;

    @Transactional
    public Post save(Post post) {
        if (post.getId() == null) {
            em.persist(post);
            return post;
        } else {
            return em.merge(post);
        }
    }
}
