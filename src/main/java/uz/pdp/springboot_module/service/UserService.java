package uz.pdp.springboot_module.service;

import uz.pdp.springboot_module.payload.UserCreator;
import uz.pdp.springboot_module.payload.UserResponse;

public interface UserService {
    UserResponse create(UserCreator creator);

    UserResponse findById(Long id);

    void deleteById(Long id);

    void deleteByIdV2(Long id);
}
