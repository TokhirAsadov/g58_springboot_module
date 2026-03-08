package uz.pdp.springboot_module.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import uz.pdp.springboot_module.entity.Person;
import uz.pdp.springboot_module.payload.AddressDTO;
import uz.pdp.springboot_module.payload.PassportDTO;
import uz.pdp.springboot_module.payload.PersonDTO;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "personAddressRegion", source = "addressDTO.region")
    @Mapping(target = "personAddressCity", source = "addressDTO.city")
    @Mapping(target = "personAddressStreet", source = "addressDTO.street")
    @Mapping(target = "personPassportSeria", source = "passportDTO.series")
    @Mapping(target = "personPassportNumber", source = "passportDTO.number")
    Person toEntity(PersonDTO personDTO, AddressDTO addressDTO, PassportDTO passportDTO);

}
