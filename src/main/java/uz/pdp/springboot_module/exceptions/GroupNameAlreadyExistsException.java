package uz.pdp.springboot_module.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GroupNameAlreadyExistsException extends RuntimeException {
    public GroupNameAlreadyExistsException(String message) {
        super(message);
    }
}
