package uz.pdp.springboot_module.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_module.hateoas.UserModelAssembler;
import uz.pdp.springboot_module.payload.UserCreator;
import uz.pdp.springboot_module.payload.UserResponse;
import uz.pdp.springboot_module.service.UserService;
import uz.pdp.springboot_module.utils.Constants;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public static final String BASE_URL = Constants.BASE_URL + "/users";
    private final UserService userService;
    private final UserModelAssembler userModelAssembler;
    private final PagedResourcesAssembler<UserResponse> pagedResourcesAssembler;

    public UserController(UserService userService, UserModelAssembler userModelAssembler,@Qualifier("userResponsePagedResourcesAssembler") PagedResourcesAssembler<UserResponse> pagedResourcesAssembler) {
        this.userService = userService;
        this.userModelAssembler = userModelAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UserCreator creator) {
        UserResponse response = userService.create(creator);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<EntityModel<UserResponse>> findById(@PathVariable Long id) {
        UserResponse response = userService.findById(id);
        EntityModel<UserResponse> model = userModelAssembler.toModel(response);
        return ResponseEntity.ok(model);
    }

    @GetMapping("/findAll")
    public ResponseEntity<CollectionModel<EntityModel<UserResponse>>> findAll() {
        List<UserResponse> users = userService.findAll();
        CollectionModel<EntityModel<UserResponse>> collectionModel = userModelAssembler.toCollectionModel(users);
        return ResponseEntity.ok(collectionModel);
    }

    @GetMapping("/page")
    public ResponseEntity<PagedModel<EntityModel<UserResponse>>> page(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserResponse> users = userService.findAll(pageable);
        return ResponseEntity.ok(pagedResourcesAssembler.toModel(users, userModelAssembler));
    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/deleteByIdV2/{id}")
    public ResponseEntity<Void> deleteByIdV2(@PathVariable Long id) {
        userService.deleteByIdV2(id);
        return ResponseEntity.status(204).build();
    }
}
