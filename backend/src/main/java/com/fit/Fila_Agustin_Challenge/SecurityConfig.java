package com.fit.Fila_Agustin_Challenge;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/assets/listar", "/api/crear_cuenta", "/api/login").permitAll()
                .antMatchers("/api/exchanges/mejoresExchanges").authenticated()
                .and()
                .formLogin()
                .and().csrf().disable();
    }
}
