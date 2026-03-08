package uz.pdp.springboot_module.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;
import uz.pdp.springboot_module.entity.DayOfWeek;
import uz.pdp.springboot_module.payload.HaftaKuni;

@Mapper(componentModel = "spring")
public interface EnumMapper {

    EnumMapper INSTANCE = Mappers.getMapper(EnumMapper.class);

    @ValueMapping(target = "MONDAY", source = "DUSHANBA")
    @ValueMapping(target = "TUESDAY", source = "SESHANBA")
    @ValueMapping(target = "WEDNESDAY", source = "CHORSHANBA")
    @ValueMapping(target = "FRIDAY", source = "JUMA")
    DayOfWeek toDayOfWeek(HaftaKuni haftaKuni);

    @InheritInverseConfiguration
    HaftaKuni toHaftaKuni(DayOfWeek dayOfWeek);

}
