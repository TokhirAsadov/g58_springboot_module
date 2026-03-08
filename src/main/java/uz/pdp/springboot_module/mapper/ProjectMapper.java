package uz.pdp.springboot_module.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import uz.pdp.springboot_module.entity.Project;
import uz.pdp.springboot_module.payload.ProjectDTO;

import java.nio.file.Path;

@Mapper(
        componentModel = "spring",
        uses = {ProjectColumnMapper.class}
)
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd-MM-YYYY HH:mm:ss")
    @Mapping(target = "path", source = "path", qualifiedByName = "pathToString")
    ProjectDTO toDTO(Project project);

    @Named("pathToString")
    default String pathToString123(Path path) {
        if (path == null) {
            return null;
        }
        return path.toString();
    }
}
