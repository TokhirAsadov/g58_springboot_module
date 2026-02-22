package uz.pdp.springboot_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.springboot_module.entity.Group;
import uz.pdp.springboot_module.payload.group.GetGroupFullInfo;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Boolean existsByName(String name);

    @Query(nativeQuery = true,
            value = "select g.id, g.name as group_name, g.level as group_level from groups g where g.id = :id")
    GetGroupFullInfo getGroupFullInfo(@Param("id") Long id);
}
