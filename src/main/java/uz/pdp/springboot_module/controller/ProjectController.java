package uz.pdp.springboot_module.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springboot_module.entity.Project;
import uz.pdp.springboot_module.entity.ProjectColumn;
import uz.pdp.springboot_module.mapper.ProjectMapper;
import uz.pdp.springboot_module.payload.ProjectDTO;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectMapper mapper;

    public ProjectController(ProjectMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/toDTO")
    public ProjectDTO toDTO() {
        return mapper.toDTO(
                new Project(
                       "1",
                        "Project Alpha",
                        Path.of("D:\\pdp\\G58\\Springboot\\springboot_module"),
                        List.of(
                                new ProjectColumn("1", "To Do", "Tasks that need to be done"),
                                new ProjectColumn("2", "In Progress", "Tasks that are currently being worked on"),
                                new ProjectColumn("3", "Done", "Tasks that have been completed")
                        )
                )
        );
    }


}
