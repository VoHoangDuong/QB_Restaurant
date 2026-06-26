package com.duongvh.restaurant.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);

    private static final String SECRET_KEY = "boxofficenumberoneboxofficenumberone";

    private static final long JWT_EXPIRATION = 24 * 60 * 60 * 1000L;

    private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    /**
     * Generate JWT after login
     */
    public String generateToken(UserPrincipal principal) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

        return Jwts.builder()
                .setSubject(principal.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .claim("id", principal.getUserId())
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Get username from token
     */
    public String getUsernameFromToken(String token) {

        try {
            return getClaims(token).getSubject();
        } catch (Exception e) {
            log.error("Cannot get username from token", e);
            return null;
        }
    }

    /**
     * Get expiration date
     */
    public Date getExpirationDate(String token) {

        try {
            return getClaims(token).getExpiration();
        } catch (Exception e) {
            log.error("Cannot get expiration date", e);
            return null;
        }
    }

    /**
     * Check token expired
     */
    public boolean isTokenExpired(String token) {

        Date expiration = getExpirationDate(token);

        return expiration == null || expiration.before(new Date());
    }

    /**
     * Validate token
     */
    public boolean validateToken(String token) {

        try {

            if (token == null || token.trim().isEmpty()) {
                return false;
            }

            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }

            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);

            return true;

        } catch (ExpiredJwtException e) {

            log.error("JWT expired");

        } catch (UnsupportedJwtException e) {

            log.error("Unsupported JWT");

        } catch (MalformedJwtException e) {

            log.error("Malformed JWT");

        } catch (SignatureException e) {

            log.error("Invalid signature");

        } catch (IllegalArgumentException e) {

            log.error("Empty JWT");

        } catch (Exception e) {

            log.error("Validate JWT error", e);
        }

        return false;
    }

    /**
     * Parse claims
     */
    public Claims getClaims(String token) {

        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
}