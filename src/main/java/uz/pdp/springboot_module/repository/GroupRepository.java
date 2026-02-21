package uz.pdp.springboot_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springboot_module.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Boolean existsByName(String name);
}
