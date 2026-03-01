package uz.pdp.springboot_module.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springboot_module.entity.AuthUser;
import uz.pdp.springboot_module.payload.auth.RegisterRequest;
import uz.pdp.springboot_module.payload.auth.TokenRequest;
import uz.pdp.springboot_module.repository.AuthRoleRepository;
import uz.pdp.springboot_module.repository.AuthUserRepository;
import uz.pdp.springboot_module.security.jwt.JwtTokenUtil;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final AuthUserRepository authUserRepository;
    private final AuthRoleRepository authRoleRepository;

    @PostMapping("/token")
    public String generateToken(@RequestBody TokenRequest tokenRequest) {
        String username = tokenRequest.username();
        String password = tokenRequest.password();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        authenticationManager.authenticate(authenticationToken);
        return jwtTokenUtil.generateToken(username);
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest registerRequest) {

        AuthUser authUser = AuthUser.builder()
                .fullName(registerRequest.fullName())
                .username(registerRequest.username())
                .password(passwordEncoder.encode(registerRequest.password()))
                .roles(authRoleRepository.findAllById(registerRequest.rolesIds()))
                .build();
        authUserRepository.save(authUser);

        return "User registered successfully!";
    }
}
