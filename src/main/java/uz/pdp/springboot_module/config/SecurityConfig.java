package uz.pdp.springboot_module.config;

import jakarta.servlet.ServletOutputStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import tools.jackson.databind.ObjectMapper;
import uz.pdp.springboot_module.payload.ErrorDto;
import uz.pdp.springboot_module.security.CustomAccessDeniedHandler;
import uz.pdp.springboot_module.security.CustomAuthenticationEntryPoint;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final ObjectMapper objectMapper;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;

    public SecurityConfig(ObjectMapper objectMapper, CustomAuthenticationEntryPoint customAuthenticationEntryPoint, CustomAccessDeniedHandler customAccessDeniedHandler) {
        this.objectMapper = objectMapper;
        this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
        this.customAccessDeniedHandler = customAccessDeniedHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(List.of("*"));
                    config.setAllowedMethods(List.of("GET", "HEAD", "OPTIONS"));
                    config.setAllowedHeaders(List.of("*"));

                    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                    source.registerCorsConfiguration("/**", config);
                    return source.getCorsConfiguration(request);
                }))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest()
                        .fullyAuthenticated()
                )
                .httpBasic(
                        httpBasicConfigurer -> httpBasicConfigurer.realmName("G58")
                            .authenticationEntryPoint(customAuthenticationEntryPoint)

                )
                .exceptionHandling(exceptionHandlingConfigurer -> exceptionHandlingConfigurer
                        //.authenticationEntryPoint(customAuthenticationEntryPoint)
                        .accessDeniedHandler(customAccessDeniedHandler)
                )
                .build();
    }

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource(){
//        return request -> {
//            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//            var corsConfiguration = new CorsConfiguration();
//            corsConfiguration.setAllowedOrigins(List.of("*"
////                    "http://1.1.1.12:5001",
////                    "http://localhost:3000"
//            ));
//            corsConfiguration.setAllowedMethods(List.of("GET"));
//            corsConfiguration.setAllowedHeaders(List.of(
//                    "*"
////                    "X-G58-Header","Content-Type"
//            ));
//
//            source.registerCorsConfiguration("/**", corsConfiguration);
//            return source.getCorsConfiguration(request);
//        };
//    }


//    @Bean
//    public AccessDeniedHandler accessDeniedHandler() {
//        return (request, response, accessDeniedException) -> {
//            accessDeniedException.printStackTrace();
//            String errorPath = request.getRequestURI();
//            String errorMessage = "Sizda bu resursga kirish uchun ruxsat yo'q!."; // accessDeniedException.getMessage();
//            Integer errorCode = 403; // Forbidden
//            ErrorDto errorDto = new ErrorDto(errorMessage, errorPath, errorCode);
//            response.setStatus(errorCode);
//            ServletOutputStream outputStream = response.getOutputStream();
//            objectMapper.writeValue(outputStream, errorDto);
//        };
//    }

//    @Bean
//    public AuthenticationEntryPoint authenticationEntryPoint() {
//        return (request, response, authException) -> {
//            authException.printStackTrace();
//            String errorPath = request.getRequestURI();
//            String errorMessage = "Avval login buling!."; // authException.getMessage();
//            Integer errorCode = 401; // Unauthorized
//            ErrorDto errorDto = new ErrorDto(errorMessage, errorPath, errorCode);
//            response.setStatus(errorCode);
//            ServletOutputStream outputStream = response.getOutputStream();
//            objectMapper.writeValue(outputStream, errorDto);
//        };
//    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.builder()
                .username("user")
                .password("123")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("123")
                .roles("USER","ADMIN")
                .build();
        UserDetails manager = User.builder()
                .username("manager")
                .password("123")
                .roles("MANAGER")
                .build();
        return new InMemoryUserDetailsManager(user, admin, manager);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // hech qachon production da ishlatmang!!!
    }
}
