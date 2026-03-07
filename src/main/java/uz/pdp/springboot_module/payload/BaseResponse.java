package uz.pdp.springboot_module.payload;

import com.fasterxml.jackson.annotation.JsonInclude;


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

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorDto getError() {
        return error;
    }

    public void setError(ErrorDto error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "success=" + success +
                ", data=" + data +
                ", error=" + error +
                '}';
    }
}
