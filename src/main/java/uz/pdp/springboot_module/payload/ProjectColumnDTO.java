package uz.pdp.springboot_module.payload;

public class ProjectColumnDTO {
    private Integer id;
    private String pc_name;
    private String description;
    private String createdAt;

    public ProjectColumnDTO() {
    }

    public ProjectColumnDTO(Integer id, String pc_name, String description, String createdAt) {
        this.id = id;
        this.pc_name = pc_name;
        this.description = description;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPc_name() {
        return pc_name;
    }

    public void setPc_name(String pc_name) {
        this.pc_name = pc_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
