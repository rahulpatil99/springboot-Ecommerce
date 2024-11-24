package com.softech.springbootEcommerce.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import java.util.TimeZone;
import java.util.Calendar;

@Component
public class JwtTokenUtil {
    @Value("${jwt.secret.key}")
    private String SECRET_KEY;

    private static final long DEFAULT_EXPIRATION_MS = 1000L * 60 * 60 * 700; // 30 days

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername(), DEFAULT_EXPIRATION_MS);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public Boolean isTokenExpired(String token) {
        try {
            Date expiration = extractExpiration(token);
            return expiration.before(new Date());
        } catch (ExpiredJwtException e) {
            return true;
        }
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private String createToken(Map<String, Object> claims, String subject, long expirationTimeMs) {
        // Get the current time in milliseconds (UTC)
        long issuedAt = System.currentTimeMillis(); // Current time
        long expirationTime = issuedAt + expirationTimeMs; // Calculate expiration time based on the current time and the expiration duration

        // Log both issued time and expiration time in milliseconds
        System.out.println("expirationTimeMs At (milliseconds): " + expirationTimeMs);
        System.out.println("Issued At (milliseconds): " + issuedAt);
        System.out.println("Expiration Time (milliseconds): " + expirationTime);

        // Convert these times to Date objects for logging in a human-readable format (UTC)
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.setTimeInMillis(issuedAt);
        System.out.println("Issued At (UTC): " + calendar.getTime());

        calendar.setTimeInMillis(expirationTime);
        System.out.println("Expiration Time (UTC): " + calendar.getTime());

        // Now, create the JWT token with the correct issued and expiration times
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(issuedAt))  // Correctly set the issued time
                .setExpiration(new Date(expirationTime))  // Correctly set the expiration time
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

}

