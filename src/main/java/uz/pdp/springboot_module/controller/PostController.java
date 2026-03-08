package uz.pdp.springboot_module.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_module.entity.Post;
import uz.pdp.springboot_module.mapper.PostMapper;
import uz.pdp.springboot_module.payload.PostDTO;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostMapper postMapper;

    public PostController(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @PostMapping("/toEntity")
    public Post toEntity(@RequestBody PostDTO postDTO) {
        return postMapper.toEntity(postDTO);
    }

    @PostMapping("/toDTO")
    public PostDTO toDTO(@RequestBody Post post) {
        return postMapper.toDTO(post);
    }
}
