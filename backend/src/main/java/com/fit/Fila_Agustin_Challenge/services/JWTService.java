package com.fit.Fila_Agustin_Challenge.services;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class JWTService {
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String crearToken(String nombreUsuario){
        String token = Jwts.builder().setSubject(nombreUsuario).
                setIssuedAt(new Date(System.currentTimeMillis())).
                setExpiration(new Date(System.currentTimeMillis() + 500000)).
                signWith(this.key).compact();

        return token;
    }
    public String nombreDeUsuarioToken(String token){
        return Jwts.parser().setSigningKey(this.key).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validarToken(String token){
        try {
            Jwts.parser().setSigningKey(this.key).parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
