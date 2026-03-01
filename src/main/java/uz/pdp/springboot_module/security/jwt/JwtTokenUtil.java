package uz.pdp.springboot_module.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final String SECRET_KEY = "t3Y5GOwa71hRJg6GD55pvpqPgQhqf3VykhAHLARSqEU";

    public String generateToken(@NonNull String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setIssuer("https://g58.uz")
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                .signWith(singKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key singKey() {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(bytes);
    }

    public String getUsernameFromToken(String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();
    }

    private Claims getClaims(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(singKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }

    public boolean isValidToken(String token) {
        try {
            Claims claims = getClaims(token);
            Date expiration = claims.getExpiration();
            return expiration.after(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
