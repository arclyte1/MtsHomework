package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@SpringBootTest(classes = {AnimalTestConfiguration.class, AnimalDataAutoConfiguration.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AnimalDataUnitTests {

    @Autowired
    private AnimalDataConfig animalDataConfig;
    @Autowired
    private AnimalData animalData;

    @Test
    @DisplayName("call getRandomWolfBreed")
    public void getRandomWolfBreedTest() {
        String randomWolfBreed = animalData.getRandomWolfBreed();
        assert (Arrays.asList(animalDataConfig.get("wolfBreeds")).contains(randomWolfBreed));
    }

    @Test
    @DisplayName("call getRandomSharkBreed")
    public void getRandomSharkBreedTest() {
        String randomSharkBreed = animalData.getRandomSharkBreed();
        assert (Arrays.asList(animalDataConfig.get("sharkBreeds")).contains(randomSharkBreed));
    }

    @Test
    @DisplayName("call getRandomCatBreed with empty cat breeds data")
    public void getRandomNotExistingCatBreedTest() {
        Exception catchedException = null;
        try {
            animalData.getRandomCatBreed();
        } catch (Exception e) {
            catchedException = e;
        }
        assertInstanceOf(IllegalArgumentException.class, catchedException);
    }

    @Test
    @DisplayName("call getRandomDogBreed with empty dog breeds data")
    public void getRandomNotExistingDogBreedTest() {
        Exception catchedException = null;
        try {
            animalData.getRandomDogBreed();
        } catch (Exception e) {
            catchedException = e;
        }
        assertInstanceOf(IllegalArgumentException.class, catchedException);
    }
}
