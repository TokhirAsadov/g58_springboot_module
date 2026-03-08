package uz.pdp.springboot_module.payload;

import java.time.LocalDateTime;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@ToString
public class PostDTO {
    private String title;
    private String content;
    private Integer order;
    private LocalDateTime createdAt = LocalDateTime.now();

    public PostDTO() {
    }

    public PostDTO(String title, String content, Integer order) {
        this.title = title;
        this.content = content;
        this.order = order;
        this.createdAt = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
