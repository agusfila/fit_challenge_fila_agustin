package com.fit.Fila_Agustin_Challenge;

import com.fit.Fila_Agustin_Challenge.repositories.UsuarioRepository;
import com.fit.Fila_Agustin_Challenge.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.fit.Fila_Agustin_Challenge.repositories")
@EntityScan("com.fit.Fila_Agustin_Challenge.entities")
public class ApiApplication{

    public static void main(String[] args){
        SpringApplication.run(ApiApplication.class, args);
    }


}
