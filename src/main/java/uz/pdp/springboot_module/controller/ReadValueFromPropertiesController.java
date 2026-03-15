package uz.pdp.springboot_module.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springboot_module.property.ExampleProperties;
import uz.pdp.springboot_module.property.PeopleProperties;
import uz.pdp.springboot_module.property.PersonProperties;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/properties")
public class ReadValueFromPropertiesController {

    private final ExampleProperties exampleProperties;
    private final PersonProperties personProperties;
    private final PeopleProperties peopleProperties;

    public ReadValueFromPropertiesController(ExampleProperties exampleProperties, PersonProperties personProperties, PeopleProperties peopleProperties) {
        this.exampleProperties = exampleProperties;
        this.personProperties = personProperties;
        this.peopleProperties = peopleProperties;
    }

    @GetMapping("/exampleString")
    public String getExampleString(){
        return exampleProperties.string();
    }

    @GetMapping("/exampleLanguages")
    public List<String> exampleLanguages(){
        return exampleProperties.languages();
    }

    @GetMapping("/exampleLanguages2")
    public List<String> exampleLanguages2(){
        return exampleProperties.languages2();
    }

    @GetMapping("/exampleNumbers")
    public Map<String,String> exampleNumbers(){
        return exampleProperties.numbers();
    }

    @GetMapping("/personProperties")
    public PersonProperties personProperties(){
        return personProperties;
    }

    @GetMapping("/peopleProperties")
    public PeopleProperties peopleProperties(){
        return peopleProperties;
    }
}
