package com.springSecurity.spring_security.config;

import com.springSecurity.spring_security.entity.UserCredentialEnitity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {

    //    private static final String STATIC_SECRET_KEY="8b6cc66d55b3d8cc4044f92449be21d7";
    private final Environment env;

    private final SecretKey secretKey;

    public JWTService(Environment env) {
        this.env = env;
        String STATIC_SECRET_KEY = env.getProperty("STATIC_SECRET_KEY");
        // Generate a secure key during construction
        byte[] keyBytes = STATIC_SECRET_KEY.getBytes();
        this.secretKey = Keys.hmacShaKeyFor(keyBytes);

    }

    public String generatetocken(UserCredentialEnitity user) {

        Map<String, Object> claim = new HashMap<>();
        return Jwts.builder()
                .setClaims(claim)
                .setSubject(user.getUsername())
                .setIssuer("DCB")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(secretKey).compact();
    }

    public String extractUserName(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimResolver) {
        Claims claims = extractClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(secretKey)  // Method used in 0.11.x
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
//    private Key getSignInKey() {
//        byte[] keyBytes = Decoders.BASE64.decode(STATIC_SECRET_KEY);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }


}
