package uz.pdp.springboot_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.springboot_module.entity.User;
import uz.pdp.springboot_module.exceptions.DataNotFoundException;
import uz.pdp.springboot_module.exceptions.UsernameAlreadyExistsException;
import uz.pdp.springboot_module.payload.BaseResponse;
import uz.pdp.springboot_module.payload.user.UserCreator;
import uz.pdp.springboot_module.payload.user.UserResponse;
import uz.pdp.springboot_module.repository.UserRepository;
import uz.pdp.springboot_module.service.UserService;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public BaseResponse<UserResponse> create(UserCreator creator) {
        boolean exists = userRepository.existsByUsername(creator.username());
        if (exists) {
            throw new UsernameAlreadyExistsException("Username '" + creator.username() + "' already exists.");
        }
        User user = User.builder()
                .lastName(creator.lastName())
                .firstName(creator.firstName())
                .username(creator.username())
                .build();
        userRepository.saveAndFlush(user);
        UserResponse userResponse = new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getUsername());
        return new BaseResponse<>(userResponse);
    }

    @Override
    public BaseResponse<UserResponse> findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new DataNotFoundException("User with id '" + id + "' not found.");
        }
        User user = optionalUser.get();
        UserResponse userResponse = new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getUsername());
        return new BaseResponse<>(userResponse);
    }

    @Override
    public void deleteById(Long id) {

        // version 2 // ✅ bu usulda ham to`g`ri ishlaydi.
//        User user = userRepository.findById(id)
//                .orElseThrow(
//                        () -> new DataNotFoundException("User with id '" + id + "' not found.")
//                );
//        user.setDeleted(true);
//        userRepository.saveAndFlush(user);


// version 1
        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw new DataNotFoundException("User with id '" + id + "' not found.");
        }
        userRepository.deleteById(id);
    }

    @Override
    public void deleteByIdV2(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(
                        () -> new DataNotFoundException("User with id '" + id + "' not found.")
                );
        user.setDeleted(true);
        user.setUsername(user.getUsername() + "_" + UUID.randomUUID());
        userRepository.saveAndFlush(user);
    }
}
