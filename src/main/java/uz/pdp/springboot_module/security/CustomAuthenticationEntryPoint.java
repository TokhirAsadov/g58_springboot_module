package uz.pdp.springboot_module.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;
import uz.pdp.springboot_module.payload.ErrorDto;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper;

    public CustomAuthenticationEntryPoint(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        authException.printStackTrace();
        String errorPath = request.getRequestURI();
        String errorMessage = "Custom.... Avval login buling."; // authException.getMessage();
        Integer errorCode = 401; // Unauthorized
        ErrorDto errorDto = new ErrorDto(errorMessage, errorPath, errorCode);
        response.setStatus(errorCode);
        ServletOutputStream outputStream = response.getOutputStream();
        objectMapper.writeValue(outputStream, errorDto);
    }
}
