package uz.pdp.springboot_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.springboot_module.entity.User;
import uz.pdp.springboot_module.payload.UserCreator;
import uz.pdp.springboot_module.payload.UserResponse;
import uz.pdp.springboot_module.repository.UserRepository;
import uz.pdp.springboot_module.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponse create(UserCreator creator) {
        User user = User.builder()
                .lastName(creator.lastName())
                .firstName(creator.firstName())
                .username(creator.username())
                .build();
        userRepository.saveAndFlush(user);
        UserResponse userResponse = new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getUsername());
        return userResponse;
    }

    @Override
    public UserResponse findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        UserResponse userResponse = new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getUsername());
        return userResponse;
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
        userRepository.deleteById(id);
    }

    @Override
    public void deleteByIdV2(Long id) {
        User user = userRepository.findById(id).get();
        user.setDeleted(true);
        user.setUsername(user.getUsername() + "_" + UUID.randomUUID());
        userRepository.saveAndFlush(user);
    }

    @Override
    public List<UserResponse> findAll() {
        List<User> users = userRepository.findAll();
        List<UserResponse> responses = users.stream()
                .map(user -> new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getUsername()))
                .toList();
        return responses;
    }

    @Override
    public Page<UserResponse> findAll(Pageable pageable) {
        Page<UserResponse> userResponses = userRepository.findAll(pageable).map(user -> new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getUsername()));
        return userResponses;
    }
}
