package org.example;

import org.example.model.*;
import org.example.utils.RandomAnimalProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@SpringBootTest(classes = {AnimalDataAutoConfiguration.class, RandomAnimalProvider.class})
public class RandomAnimalProviderUnitTests {

    @Autowired
    private RandomAnimalProvider randomAnimalProvider;

    @Test
    @DisplayName("call provide with predator types")
    void providePredatorTest() {
        AnimalType[] types = new AnimalType[]{
                AnimalType.WOLF,
                AnimalType.SHARK
        };
        Animal animal = randomAnimalProvider.provide(types);
        assert (animal instanceof Wolf || animal instanceof Shark);
    }

    @Test
    @DisplayName("call provide with pet types")
    void providePetTest() {
        AnimalType[] types = new AnimalType[]{
                AnimalType.CAT,
                AnimalType.DOG
        };
        Animal animal = randomAnimalProvider.provide(types);
        assert (animal instanceof Cat || animal instanceof Dog);
    }

    @Test
    @DisplayName("call provide with empty types array")
    void provideEmptyTypesTest() {
        Animal animal = randomAnimalProvider.provide(new AnimalType[0]);
        assert (animal == null);
    }

    @Test
    @DisplayName("call provide with duplication in types array")
    void provideDuplicateTypesTest() {
        AnimalType[] types = new AnimalType[]{
                AnimalType.CAT,
                AnimalType.CAT
        };
        Animal animal = randomAnimalProvider.provide(types);
        assertInstanceOf(Cat.class, animal);
    }
}
