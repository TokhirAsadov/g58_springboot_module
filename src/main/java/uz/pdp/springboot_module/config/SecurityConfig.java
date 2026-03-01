package uz.pdp.springboot_module.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import tools.jackson.databind.ObjectMapper;
import uz.pdp.springboot_module.security.CustomAccessDeniedHandler;
import uz.pdp.springboot_module.security.CustomAuthenticationEntryPoint;
import uz.pdp.springboot_module.security.jwt.JwtTokenFilter;
import uz.pdp.springboot_module.security.jwt.JwtTokenUtil;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final ObjectMapper objectMapper;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;
    private final JwtTokenUtil jwtTokenUtil;

    public SecurityConfig(ObjectMapper objectMapper, CustomAuthenticationEntryPoint customAuthenticationEntryPoint, CustomAccessDeniedHandler customAccessDeniedHandler, JwtTokenUtil jwtTokenUtil) {
        this.objectMapper = objectMapper;
        this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
        this.customAccessDeniedHandler = customAccessDeniedHandler;
        this.jwtTokenUtil = jwtTokenUtil;
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
                        .requestMatchers("/api/auth/**").permitAll()
                        .anyRequest()
                        .fullyAuthenticated()
                )
                .sessionManagement(sessionManagementConfigurer -> sessionManagementConfigurer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .exceptionHandling(exceptionHandlingConfigurer -> exceptionHandlingConfigurer
                        .authenticationEntryPoint(customAuthenticationEntryPoint)
                        .accessDeniedHandler(customAccessDeniedHandler)
                )
                .addFilterBefore(new JwtTokenFilter(jwtTokenUtil, userDetailsService()), UsernamePasswordAuthenticationFilter.class)
                .build();
    }

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

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;

    }

    @Bean
    public AuthenticationManager authenticationManager(){
        return new ProviderManager(authenticationProvider());
    }
}
