package uz.pdp.springboot_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springboot_module.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
