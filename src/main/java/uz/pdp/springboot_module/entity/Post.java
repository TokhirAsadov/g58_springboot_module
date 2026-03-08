package uz.pdp.springboot_module.entity;

import lombok.*;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@ToString
public class Post {
    private String id;
    private String p_title;
    private String p_content;
    private String order;
    private String createdAt;

    public Post() {
    }

    public Post(String id, String p_title, String p_content, String order, String createdAt) {
        this.id = id;
        this.p_title = p_title;
        this.p_content = p_content;
        this.order = order;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getP_title() {
        return p_title;
    }

    public void setP_title(String p_title) {
        this.p_title = p_title;
    }

    public String getP_content() {
        return p_content;
    }

    public void setP_content(String p_content) {
        this.p_content = p_content;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
