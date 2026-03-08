package uz.pdp.springboot_module.payload;

import java.util.List;

public class ProjectDTO {
    private Integer id;
    private String name;
    private String path;
    private List<ProjectColumnDTO> columns;
    private String createdAt;

    public ProjectDTO() {
    }

    public ProjectDTO(Integer id, String name, String path, List<ProjectColumnDTO> columns, String createdAt) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.columns = columns;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<ProjectColumnDTO> getColumns() {
        return columns;
    }

    public void setColumns(List<ProjectColumnDTO> columns) {
        this.columns = columns;
    }
}
