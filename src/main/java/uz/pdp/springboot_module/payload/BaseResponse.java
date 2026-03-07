package uz.pdp.springboot_module.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
    Boolean success;
    T data;
    ErrorDto error;

    public BaseResponse(T data) {
        this.success = true;
        this.data = data;
    }

    public BaseResponse(ErrorDto error) {
        this.success = false;
        this.error = error;
    }

    public BaseResponse<T> ok(T data) {
        this.success = true;
        this.data = data;
        return this;
    }

    public BaseResponse<T> error(ErrorDto error) {
        this.success = false;
        this.error = error;
        return this;
    }
}
