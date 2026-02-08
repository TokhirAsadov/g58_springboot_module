package uz.pdp.springboot_module.payload;

public record Todo (
    Integer id,
    String title,
    Integer priority
){
}
