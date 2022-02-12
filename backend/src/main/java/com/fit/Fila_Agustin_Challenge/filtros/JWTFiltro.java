package com.fit.Fila_Agustin_Challenge.filtros;

import com.fit.Fila_Agustin_Challenge.services.JWTService;
import com.sun.org.apache.xerces.internal.parsers.SecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class JWTFiltro extends GenericFilterBean {

    private final List<String> exclusiones = Arrays.asList("/api/login");

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
        filterChain.doFilter(servletRequest, servletResponse);

        try {
            /*String token = httpServletRequest.getHeader("Authorization");
            JWTService jwtService = new JWTService();
            jwtService.validarToken(token);*/
        } catch (Exception e){

        }
    }
}
