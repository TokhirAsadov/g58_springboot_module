package uz.pdp.springboot_module.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
public class ErrorDto {
    @JsonProperty("error_code")
    private Integer errorCode;
    @JsonProperty("error_path")
    private String errorPath;
    @JsonProperty("error_body")
    private Object errorBody;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}
