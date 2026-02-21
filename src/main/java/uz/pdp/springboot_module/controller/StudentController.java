package uz.pdp.springboot_module.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springboot_module.service.StudentService;
import uz.pdp.springboot_module.utils.Constants;

@RestController
@RequiredArgsConstructor
@RequestMapping(StudentController.BASE_URL)
public class StudentController {
    public static final String BASE_URL = Constants.BASE_URL+"/students";
    private final StudentService studentService;


}
