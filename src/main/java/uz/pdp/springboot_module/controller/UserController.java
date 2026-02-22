package uz.pdp.springboot_module.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_module.payload.BaseResponse;
import uz.pdp.springboot_module.payload.user.UserCreator;
import uz.pdp.springboot_module.payload.user.UserResponse;
import uz.pdp.springboot_module.service.UserService;
import uz.pdp.springboot_module.utils.Constants;

@RestController
@RequestMapping(UserController.BASE_URL)
@RequiredArgsConstructor
public class UserController {
    public static final String BASE_URL = Constants.BASE_URL + "/users";
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<UserResponse>> create(@RequestBody @Valid UserCreator creator) {
        BaseResponse<UserResponse> response = userService.create(creator);
        return ResponseEntity.status(response.getSuccess() ? 201 : 400).body(response);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<BaseResponse<UserResponse>> findById(@PathVariable Long id) {
        BaseResponse<UserResponse> response = userService.findById(id);
        return ResponseEntity.status(response.getSuccess() ? 200 : 400).body(response);
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
