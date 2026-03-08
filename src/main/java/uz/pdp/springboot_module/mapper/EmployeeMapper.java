package uz.pdp.springboot_module.mapper;

import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import uz.pdp.springboot_module.entity.Employee;
import uz.pdp.springboot_module.entity.Person;
import uz.pdp.springboot_module.payload.AddressDTO;
import uz.pdp.springboot_module.payload.PassportDTO;
import uz.pdp.springboot_module.payload.PersonDTO;

import java.util.Map;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @MapMapping(keyTargetType = String.class, valueTargetType = String.class)
    Employee toEntityByMap(Map<String, String> map);

    @MapMapping(keyTargetType = String.class, valueTargetType = Object.class)
    Employee toEntityByMap2(Map<String, Object> map);

    default String fromObjectToString(Object o){
        return String.valueOf(o);
    }

    /*
    {
        "id" : 1,
        "firstName":"ALi",
        "lastName": "Aliyev",
        "age": 20
    }
    * */
}
