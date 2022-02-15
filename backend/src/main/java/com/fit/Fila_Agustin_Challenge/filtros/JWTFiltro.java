package com.fit.Fila_Agustin_Challenge.filtros;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fit.Fila_Agustin_Challenge.services.JWTService;
import com.sun.org.apache.xerces.internal.parsers.SecurityConfiguration;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JWTFiltro extends GenericFilterBean {

    @Autowired
    private JWTService jwtService;

    private final List<String> exclusiones = Arrays.asList("/api/auth/");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String path = httpServletRequest.getRequestURI();
        for(String exclusion : exclusiones){
            if(path.startsWith(exclusion)){
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        String token    = httpServletRequest.getHeader("Authorization");
        try {
            if(token == null) throw new Exception("Token nulo");
            else token           = token.replace("Bearer ", "");
            if(token != null && jwtService.validarToken(token)){
                String nombreUsuario = jwtService.nombreDeUsuarioToken(token);
            } else throw new Exception("Token invalido");
        } catch (Exception e){
            ObjectMapper objectMapper       = new ObjectMapper();
            HttpServletResponse response    = (HttpServletResponse) servletResponse;
            Map<String, Object> respuesta   = new HashMap<>();

            respuesta.put("mensaje", e.getMessage());
            respuesta.put("codigo", HttpStatus.BAD_REQUEST);

            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType("application/json");
            objectMapper.writeValue(response.getWriter(), respuesta);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
