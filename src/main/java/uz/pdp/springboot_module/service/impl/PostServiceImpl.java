package uz.pdp.springboot_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.pdp.springboot_module.entity.Post;
import uz.pdp.springboot_module.repository.PostRepository;
import uz.pdp.springboot_module.service.PostService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public Page<Post> getAllPosts(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size)
                .withSort(Sort.by(Sort.Direction.DESC, "id"));
        return postRepository.getAllPosts(pageable);
    }

    @Override
    public List<Post> findPostsByUserId(Integer userId, String order) {
        Sort sort = Sort.by(Sort.Direction.DESC, order == null ? "id" : order);
        return postRepository.getPostsByUserId(userId, sort);
    }
}
