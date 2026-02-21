package uz.pdp.springboot_module.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.pdp.springboot_module.payload.BaseResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<BaseResponse<Object>> handleDataNotFoundException(DataNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new BaseResponse<>(
                                ErrorDto.builder()
                                        .errorCode(404)
                                        .errorBody(ex.getMessage())
                                        .errorPath(request.getRequestURI())
                                        .build()
                        )
                );
    }

    @ExceptionHandler(GroupNameAlreadyExistsException.class)
    public ResponseEntity<BaseResponse<ErrorDto>> handleGroupNameAlreadyExistsException(GroupNameAlreadyExistsException ex, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new BaseResponse<>(
                                ErrorDto.builder()
                                        .errorCode(400)
                                        .errorBody(ex.getMessage())
                                        .errorPath(request.getRequestURI())
                                        .build()
                        )
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        Map<String, List<String>> errorBody = new HashMap<>();
        for (FieldError fieldError : ex.getFieldErrors()) {
            String field = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            errorBody.compute(field, (key, messages) -> {
                if (messages == null) {
                    messages = new ArrayList<>();
                }
                messages.add(defaultMessage);
                return messages;
            });
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new BaseResponse<>(
                                ErrorDto.builder()
                                        .errorCode(400)
                                        .errorBody(errorBody)
                                        .errorPath(request.getRequestURI())
                                        .build()

                        )
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<Object>> handleGenericException(Exception ex, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new BaseResponse<>(
                                ErrorDto.builder()
                                        .errorCode(500)
                                        .errorBody(ex.getMessage())
                                        .errorPath(request.getRequestURI())
                                        .build()
                        )
                );
    }
}
