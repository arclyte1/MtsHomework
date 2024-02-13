package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(AnimalData.class)
@EnableConfigurationProperties(AnimalDataProperties.class)
public class AnimalDataAutoConfiguration {

    @Autowired
    private AnimalDataProperties animalDataProperties;

    @Bean
    @ConditionalOnMissingBean
    public AnimalDataConfig animalDataConfig() {
        AnimalDataConfig animalDataConfig = new AnimalDataConfig();

        animalDataConfig.put("names", animalDataProperties.getNames());
        animalDataConfig.put("dogBreeds", animalDataProperties.getDogBreeds());
        animalDataConfig.put("catBreeds", animalDataProperties.getCatBreeds());
        animalDataConfig.put("sharkBreeds", animalDataProperties.getSharkBreeds());
        animalDataConfig.put("wolfBreeds", animalDataProperties.getWolfBreeds());
        animalDataConfig.put("characters", animalDataProperties.getCharacters());

        return animalDataConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public AnimalData animalData(AnimalDataConfig config) {
        return new AnimalData(config);
    }
}
