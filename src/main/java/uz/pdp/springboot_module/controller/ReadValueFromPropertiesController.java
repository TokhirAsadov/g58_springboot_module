package uz.pdp.springboot_module.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springboot_module.property.PeopleProperties;
import uz.pdp.springboot_module.property.PersonProperties;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/properties")
public class ReadValueFromPropertiesController {

    @Value("${example.string:Default string..}")
    private String exampleString;

    @Value("${example.languages}")
    private List<String> exampleLanguages;

    @Value("#{'${example.languages2}'.split('# ')}")
    private List<String> exampleLanguages2;

    @Value("#{${example.numbers}}")
    private Map<String,String> exampleNumbers;

    private final PersonProperties personProperties;
    private final PeopleProperties peopleProperties;

    public ReadValueFromPropertiesController(PersonProperties personProperties, PeopleProperties peopleProperties) {
        this.personProperties = personProperties;
        this.peopleProperties = peopleProperties;
    }

    @GetMapping("/exampleString")
    public String getExampleString(){
        return exampleString;
    }
    @GetMapping("/exampleLanguages")
    public List<String> exampleLanguages(){
        return exampleLanguages;
    }
    @GetMapping("/exampleLanguages2")
    public List<String> exampleLanguages2(){
        return exampleLanguages2;
    }
    @GetMapping("/exampleNumbers")
    public Map<String,String> exampleNumbers(){
        return exampleNumbers;
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
