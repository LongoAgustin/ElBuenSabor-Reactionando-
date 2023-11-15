package com.tup.buensabor.JWT;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static String SECRET_KEY = "AAAAAAAAAAJAJAJAJAJAJAJAJASSSSSSSSSSSSSSSSSSSSSSSSSSSGGGGGGGGGGGGGGGGGGGGGGERT435345";

    private String getToken(Map<String, Object> extraClaims, UserDetails usuario){
        return Jwts
            .builder()
            .claims(extraClaims)
            .subject(usuario.getUsername())
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis()+1000*60*24))
            .signWith(getKey())
            .compact();
    }

    public String getToken(UserDetails usuario) {
        return getToken(new HashMap<>(), usuario);
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
}
