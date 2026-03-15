package uz.pdp.springboot_module.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_module.entity.Person;
import uz.pdp.springboot_module.mapper.PersonMapper;
import uz.pdp.springboot_module.payload.AddressDTO;
import uz.pdp.springboot_module.payload.PassportDTO;
import uz.pdp.springboot_module.payload.PersonCreator;
import uz.pdp.springboot_module.payload.PersonDTO;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonMapper mapper;

    public PersonController(PersonMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/toEntity")
    public Person toEntity() {
        return mapper.toEntity(
                new PersonDTO("John Doe", 30),
                new AddressDTO("Tashkent", "Yunusabad", "123 Street"),
                new PassportDTO("AB", "1234567")
        );
    }

    @PostMapping("/toEntity2")
    public Person toEntity2(@RequestBody PersonCreator creator) {
        return mapper.toEntity(
                creator.personDTO(),
                creator.addressDTO(),
                creator.passportDTO()
        );
    }


}
