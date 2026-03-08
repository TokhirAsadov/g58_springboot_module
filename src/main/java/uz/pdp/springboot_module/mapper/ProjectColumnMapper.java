package uz.pdp.springboot_module.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import uz.pdp.springboot_module.entity.ProjectColumn;
import uz.pdp.springboot_module.payload.ProjectColumnDTO;

@Mapper(componentModel = "spring")
public interface ProjectColumnMapper {

    ProjectColumnMapper INSTANCE = Mappers.getMapper(ProjectColumnMapper.class);

    @Mapping(target = "pc_name", source = "name")
    @Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd-MM-YYYY HH:mm:ss")
    ProjectColumnDTO toDTO(ProjectColumn projectColumn);


}
