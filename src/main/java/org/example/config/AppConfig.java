package org.example.config;

import org.example.service.CreateAnimalService;
import org.example.service.CreateAnimalServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class AppConfig {

    @Bean
    @Scope(value = "prototype")
    public CreateAnimalService createAnimalService() {
        return new CreateAnimalServiceImpl();
    }
}
