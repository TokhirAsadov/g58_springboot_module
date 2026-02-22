package uz.pdp.springboot_module.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.pdp.springboot_module.payload.UserCreator;
import uz.pdp.springboot_module.payload.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create(UserCreator creator);

    UserResponse findById(Long id);

    void deleteById(Long id);

    void deleteByIdV2(Long id);

    List<UserResponse> findAll();

    Page<UserResponse> findAll(Pageable pageable);
}
