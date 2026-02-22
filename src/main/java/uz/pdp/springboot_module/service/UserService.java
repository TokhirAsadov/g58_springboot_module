package uz.pdp.springboot_module.service;

import uz.pdp.springboot_module.payload.BaseResponse;
import uz.pdp.springboot_module.payload.user.UserCreator;
import uz.pdp.springboot_module.payload.user.UserResponse;

public interface UserService {
    BaseResponse<UserResponse> create(UserCreator creator);

    BaseResponse<UserResponse> findById(Long id);

    void deleteById(Long id);

    void deleteByIdV2(Long id);
}
