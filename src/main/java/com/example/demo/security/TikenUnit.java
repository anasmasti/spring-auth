package com.example.demo.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TikenUnit {

    @Value(value = "auth.expiration")
    private Long expiration;

    @Value(value = "auth.secret")
    private Long secret;

    private String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", userDetails.getUsername());
        claims.put("created", new Date());

        return Jwts
        .builder()
        .setClaims(claims)
        .setExpiration(generateExpirationDate())
        .signWith(SignatureAlgorithm.HS384, secret)
        .compact();
    }

    private Date generateExpirationDate() {
       return new Date(System.currentTimeMillis() + expiration * 1000);
    }

}
