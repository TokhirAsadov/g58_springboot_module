package uz.pdp.springboot_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.springboot_module.entity.User;

@RepositoryRestResource(path = "odamlar", collectionResourceRel = "odamlar", itemResourceRel = "odam")
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
}
