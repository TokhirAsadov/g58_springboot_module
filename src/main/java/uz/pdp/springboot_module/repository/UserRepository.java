package uz.pdp.springboot_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springboot_module.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
}
