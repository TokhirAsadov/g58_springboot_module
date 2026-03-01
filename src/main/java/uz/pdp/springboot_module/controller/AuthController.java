package uz.pdp.springboot_module.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springboot_module.payload.TokenRequest;
import uz.pdp.springboot_module.security.jwt.JwtTokenUtil;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public String generateToken(@RequestBody TokenRequest tokenRequest) {
        String username = tokenRequest.username();
        String password = tokenRequest.password();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        authenticationManager.authenticate(authenticationToken);
        return jwtTokenUtil.generateToken(username);
    }
}
