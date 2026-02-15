package uz.pdp.springboot_module.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_module.entity.Post;
import uz.pdp.springboot_module.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/getAllPosts")
    public Page<Post> getAllPosts(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size
    ) {
        return postService.getAllPosts(page, size);
    }

    @GetMapping("/findByUserId/{userId}")
    public List<Post> findPostsByUserId(
            @PathVariable Integer userId,
            @RequestParam(name = "order", required = false) String order
    ) {
        return postService.findPostsByUserId(userId, order);
    }

    @GetMapping("/findPostsByUserIds")
    public List<Post> findPostsByUserId(
            @RequestParam List<Integer> usersIds,
            @RequestParam(name = "order", required = false) String order
    ) {
        return postService.findPostsByUserIds(usersIds, order);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Post update(@RequestBody Post post) {
        return postService.update(post);
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        postService.deleteById(id);
    }

    @GetMapping("/findByIdOrUserId")
    public List<Post> findByIdOrUserId(
            @RequestParam Integer idOrUserId
    ){
        return postService.findByIdOrUserId(idOrUserId);
    }
}
