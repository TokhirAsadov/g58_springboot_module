package uz.pdp.springboot_module.service;

import uz.pdp.springboot_module.payload.BaseResponse;
import uz.pdp.springboot_module.payload.student.StudentCreator;
import uz.pdp.springboot_module.payload.student.StudentResponse;

import java.util.List;

public interface StudentService {
    BaseResponse<StudentResponse> create(StudentCreator creator);

    BaseResponse<StudentResponse> findById(Long id);

    BaseResponse<List<StudentResponse>> findAll();

}
