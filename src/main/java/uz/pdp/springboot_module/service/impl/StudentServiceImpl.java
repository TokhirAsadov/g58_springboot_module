package uz.pdp.springboot_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.springboot_module.entity.Group;
import uz.pdp.springboot_module.entity.Student;
import uz.pdp.springboot_module.exceptions.DataNotFoundException;
import uz.pdp.springboot_module.payload.BaseResponse;
import uz.pdp.springboot_module.payload.GroupResponse;
import uz.pdp.springboot_module.payload.StudentCreator;
import uz.pdp.springboot_module.payload.StudentResponse;
import uz.pdp.springboot_module.repository.GroupRepository;
import uz.pdp.springboot_module.repository.StudentRepository;
import uz.pdp.springboot_module.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Override
    public BaseResponse<StudentResponse> create(StudentCreator creator) {
        Optional<Group> optionalGroup = groupRepository.findById(creator.groupId());
        if (optionalGroup.isEmpty()) {
            throw new DataNotFoundException("Group with id " + creator.groupId() + " not found");
        }
        Group group = optionalGroup.get();
        Student student = Student.builder()
                .firstName(creator.firstName())
                .lastName(creator.lastName())
                .age(creator.age())
                .birthYear(creator.birthYear())
                .group(group)
                .build();
        studentRepository.saveAndFlush(student);

        StudentResponse response = new StudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.getBirthYear(),
                new GroupResponse(
                        group.getId(),
                        group.getName(),
                        group.getLevel()
                )
        );
        return new BaseResponse<>(response);
    }

    @Override
    public BaseResponse<StudentResponse> findById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
            throw new DataNotFoundException("Student with id " + id + " not found");
        }
        Student student = optionalStudent.get();

        StudentResponse response = new StudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.getBirthYear(),
                new GroupResponse(
                        student.getGroup().getId(),
                        student.getGroup().getName(),
                        student.getGroup().getLevel()
                )
        );
        return new BaseResponse<>(response);
    }

    @Override
    public BaseResponse<List<StudentResponse>> findAll() {
        List<StudentResponse> studentResponses = studentRepository.findAll().stream().map(student -> new StudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.getBirthYear(),
                new GroupResponse(
                        student.getGroup().getId(),
                        student.getGroup().getName(),
                        student.getGroup().getLevel()
                )
        )).toList();
        return new BaseResponse<>(studentResponses);
    }
}
