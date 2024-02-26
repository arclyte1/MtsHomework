package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
@EnableConfigurationProperties(AnimalDataProperties.class)
public class AnimalTestConfiguration {

    @Autowired
    private AnimalDataProperties animalDataProperties;

    @Bean
    @ConditionalOnMissingBean
    public AnimalDataConfig animalDataConfig() {
        AnimalDataConfig animalDataConfig = new AnimalDataConfig();

        animalDataConfig.put("names", animalDataProperties.getNames());
        animalDataConfig.put("dogBreeds", new String[0]);
        animalDataConfig.put("catBreeds", new String[0]);
        animalDataConfig.put("sharkBreeds", animalDataProperties.getSharkBreeds());
        animalDataConfig.put("wolfBreeds", animalDataProperties.getWolfBreeds());
        animalDataConfig.put("characters", animalDataProperties.getCharacters());

        return animalDataConfig;
    }
}
