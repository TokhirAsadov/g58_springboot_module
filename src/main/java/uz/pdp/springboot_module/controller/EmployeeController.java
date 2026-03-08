package uz.pdp.springboot_module.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_module.entity.Employee;
import uz.pdp.springboot_module.mapper.EmployeeMapper;

import java.util.Map;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeMapper mapper;

    public EmployeeController(EmployeeMapper mapper) {
        this.mapper = mapper;
    }


    @PostMapping("/toEntityByMap")
    public Employee toEntityByMap(@RequestBody Map<String, String> map) {
        return mapper.toEntityByMap(map);
    }

    @PostMapping("/toEntityByMap2")
    public Employee toEntityByMap2(@RequestBody Map<String, Object> map) {
        return mapper.toEntityByMap2(map);
    }

}
