package uz.pdp.springboot_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.springboot_module.repository.StudentRepository;
import uz.pdp.springboot_module.service.StudentService;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

}
