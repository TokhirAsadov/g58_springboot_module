package uz.pdp.springboot_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.springboot_module.entity.Student;
import uz.pdp.springboot_module.payload.student.GetStudentResponse;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(nativeQuery = true, value = "select s.id, s.first_name, s.last_name, s.age from students s where s.group_id = :groupId")
    List<GetStudentResponse> getAllStudents(@Param("groupId") Long groupId);

    @Query(nativeQuery = true, value = "select s.id, s.first_name, s.last_name, s.age from students s where s.group_id = :groupId and s.age >= :age")
    List<GetStudentResponse> getStudentsByAgeGreaterThenAndEqueal(@Param("groupId") Long groupId,@Param("age") Integer age);

    @Query(nativeQuery = true, value = "select s.id, s.first_name, s.last_name, s.age from students s where s.group_id = :groupId and s.age < :age")
    List<GetStudentResponse> getStudentsByAgeLessThen(@Param("groupId") Long groupId,@Param("age") Integer age);
}
