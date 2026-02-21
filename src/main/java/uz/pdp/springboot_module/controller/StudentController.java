package uz.pdp.springboot_module.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_module.payload.BaseResponse;
import uz.pdp.springboot_module.payload.StudentCreator;
import uz.pdp.springboot_module.payload.StudentResponse;
import uz.pdp.springboot_module.service.StudentService;
import uz.pdp.springboot_module.utils.Constants;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(StudentController.BASE_URL)
public class StudentController {
    public static final String BASE_URL = Constants.BASE_URL+"/students";
    private final StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<StudentResponse>> create(@RequestBody @Valid StudentCreator creator) {
        BaseResponse<StudentResponse> response = studentService.create(creator);
        return ResponseEntity.status(response.getSuccess() ? 201 : 400).body(response);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<BaseResponse<StudentResponse>> findById(@PathVariable Long id) {
        BaseResponse<StudentResponse> response = studentService.findById(id);
        return ResponseEntity.status(response.getSuccess() ? 200 : 404).body(response);
    }

    @GetMapping("/findAll")
    public ResponseEntity<BaseResponse<List<StudentResponse>>> findAll() {
        BaseResponse<List<StudentResponse>> response = studentService.findAll();
        return ResponseEntity.status(response.getSuccess() ? 200 : 404).body(response);
    }
}
