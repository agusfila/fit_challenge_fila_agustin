package com.fit.Fila_Agustin_Challenge.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class JWTService {
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String crearToken(String usuario){
        String token = Jwts.builder().setSubject(usuario).
                setIssuedAt(new Date(System.currentTimeMillis())).
                setExpiration(new Date(System.currentTimeMillis() + 500000)).
                signWith(this.key).compact();

        return token;
    }

    public void validarToken(String token){
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
        } catch (Exception e){
            String a = "";
        }
    }
}
