package uz.pdp.springboot_module.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ErrorDto {
    @JsonProperty("error_code")
    private Integer errorCode;
    @JsonProperty("error_path")
    private String errorPath;
    @JsonProperty("error_body")
    private Object errorBody;

    private LocalDateTime timestamp = LocalDateTime.now();

    public ErrorDto(Integer errorCode, String errorPath, Object errorBody, LocalDateTime timestamp) {
        this.errorCode = errorCode;
        this.errorPath = errorPath;
        this.errorBody = errorBody;
        this.timestamp = timestamp;
    }

    public ErrorDto() {
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorPath() {
        return errorPath;
    }

    public void setErrorPath(String errorPath) {
        this.errorPath = errorPath;
    }

    public Object getErrorBody() {
        return errorBody;
    }

    public void setErrorBody(Object errorBody) {
        this.errorBody = errorBody;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ErrorDto{" +
                "errorCode=" + errorCode +
                ", errorPath='" + errorPath + '\'' +
                ", errorBody=" + errorBody +
                ", timestamp=" + timestamp +
                '}';
    }
}
