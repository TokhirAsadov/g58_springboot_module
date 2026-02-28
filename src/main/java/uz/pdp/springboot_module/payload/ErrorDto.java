package uz.pdp.springboot_module.payload;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorDto {
    private String errorMessage;
    private String errorPath;
    private Integer errorCode;
    private LocalDateTime timestamp;

    public ErrorDto(String errorMessage, String errorPath, Integer errorCode) {
        this.errorMessage = errorMessage;
        this.errorPath = errorPath;
        this.errorCode = errorCode;
        this.timestamp = LocalDateTime.now();
    }
}
