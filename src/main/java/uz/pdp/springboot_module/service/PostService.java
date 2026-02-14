package uz.pdp.springboot_module.service;

import org.springframework.data.domain.Page;
import uz.pdp.springboot_module.entity.Post;

import java.util.List;

public interface PostService {
    Page<Post> getAllPosts(Integer page, Integer size);

    List<Post> findPostsByUserId(Integer userId, String order);
}
