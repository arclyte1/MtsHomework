package org.example;

import org.example.main.MainHw6;
import org.example.model.*;
import org.example.repository.AnimalsRepository;
import org.example.repository.AnimalsRepositoryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalUnitTests {

    @Nested
    class EqualsUnitTests {

        @Test
        @DisplayName("Call equals with equal classes")
        void callEqualsWithEqualClasses() {
            Cat cat1 = new Cat("breed", "name", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            Cat cat2 = new Cat("breed", "name", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            assertEquals(cat1, cat2);

            Dog dog1 = new Dog("breed", "name", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            Dog dog2 = new Dog("breed", "name", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            assertEquals(dog1, dog2);

            Wolf wolf1 = new Wolf("breed", "name", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            Wolf wolf2 = new Wolf("breed", "name", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            assertEquals(wolf1, wolf2);

            Shark shark1 = new Shark("breed", "name", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            Shark shark2 = new Shark("breed", "name", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            assertEquals(shark1, shark2);
        }

        @Test
        @DisplayName("Call equals with different field values")
        void callEqualsWithDifferentFieldValues() {
            Cat cat1 = new Cat("breed", "name", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            Cat cat2 = new Cat("breed2", "name", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            Cat cat3 = new Cat("breed", "name2", BigDecimal.valueOf(100), "character2", LocalDate.of(2000, 1, 1));
            Cat cat4 = new Cat("breed", "name", BigDecimal.valueOf(101), "character", LocalDate.of(2000, 1, 1));
            Cat cat5 = new Cat("breed", "name", BigDecimal.valueOf(100), "character", LocalDate.of(2001, 1, 1));
            assertNotEquals(cat1, cat2);
            assertNotEquals(cat1, cat3);
            assertNotEquals(cat1, cat4);
            assertNotEquals(cat1, cat5);
        }

        @Test
        @DisplayName("Call equals with different classes but same field values")
        void callEqualsWithDifferentClassesButSameFieldValues() {
            Cat cat = new Cat("breed", "name", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            Dog dog = new Dog("breed", "name", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            assertNotEquals(cat, dog);
        }
    }

    @Nested
    @ComponentScan
    class AnimalsRepositoryUnitTests {

        private static AnimalsRepositoryImpl animalsRepository;

        @BeforeAll
        static void setUp() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainHw6.class);
            animalsRepository = (AnimalsRepositoryImpl) context.getBean(AnimalsRepository.class);
        }

        @Test
        @DisplayName("Call findLeapYearNames with only leap years")
        void findLeapYearNamesWithOnlyLeapYears() {
            AbstractAnimal[] animals = new AbstractAnimal[4];
            animals[0] = new Cat(null, "cat", null, null, LocalDate.of(2024, 1, 1));
            animals[1] = new Dog(null, "dog", null, null, LocalDate.of(2020, 1, 1));
            animals[2] = new Wolf(null, "wolf", null, null, LocalDate.of(2016, 1, 1));
            animals[3] = new Shark(null, "shark", null, null, LocalDate.of(2012, 1, 1));
            animalsRepository.setAnimals(animals);

            List<String> foundNames = Arrays.asList(animalsRepository.findLeapYearNames());
            assertEquals(foundNames.size(), 4);

            List<String> names = Arrays.asList("cat", "dog", "wolf", "shark");
            assertTrue(foundNames.containsAll(names));
        }

        @Test
        @DisplayName("Call findLeapYearNames with no leap years")
        void findLeapYearNamesWithNoLeapYears() {
            AbstractAnimal[] animals = new AbstractAnimal[4];
            animals[0] = new Cat(null, "cat", null, null, LocalDate.of(2023, 1, 1));
            animals[1] = new Dog(null, "dog", null, null, LocalDate.of(2021, 1, 1));
            animals[2] = new Wolf(null, "wolf", null, null, LocalDate.of(2017, 1, 1));
            animals[3] = new Shark(null, "shark", null, null, LocalDate.of(2019, 1, 1));
            animalsRepository.setAnimals(animals);

            String[] foundNames = animalsRepository.findLeapYearNames();
            assertEquals(foundNames.length, 0);
        }

        @Test
        @DisplayName("Call findLeapYearNames with mixed leap years")
        void findLeapYearNamesWithMixedYears() {
            Animal[] animals = new Animal[4];
            animals[0] = new Cat(null, "cat", null, null, LocalDate.of(2023, 1, 1));
            animals[1] = new Dog(null, "dog", null, null, LocalDate.of(2024, 1, 1));
            animals[2] = new Wolf(null, "wolf", null, null, LocalDate.of(2017, 1, 1));
            animals[3] = new Shark(null, "shark", null, null, LocalDate.of(2020, 1, 1));
            animalsRepository.setAnimals(animals);

            List<String> foundNames = Arrays.asList(animalsRepository.findLeapYearNames());
            assertEquals(foundNames.size(), 2);

            List<String> names = Arrays.asList("dog", "shark");
            assertTrue(foundNames.containsAll(names));
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 5, 200})
        @DisplayName("Call findOlderAnimal test")
        void findOlderAnimalTest(int n) {
            Animal[] animals = new Animal[20];
            LocalDate currentDate = LocalDate.now();
            for (int i = 0; i < animals.length; i++) {
                animals[i] = new Cat(null, null, null, null, currentDate.minusYears(i));
            }
            animalsRepository.setAnimals(animals);

            Animal[] foundAnimals = animalsRepository.findOlderAnimal(n);
            LocalDate maxBirthDate = currentDate.minusYears(n);
            for (Animal animal : foundAnimals) {
                assertTrue(animal.getBirthDate().isBefore(maxBirthDate));
            }
        }

        @Test
        @DisplayName("Call findDuplicate with only duplicates")
        void findDuplicateWithOnlyDuplicates() {
            Animal[] animals = new Animal[4];
            animals[0] = new Cat("breed", "cat1", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            animals[1] = new Cat("breed", "cat1", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            animals[2] = new Cat("breed", "cat2", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            animals[3] = new Cat("breed", "cat2", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            animalsRepository.setAnimals(animals);

            Animal[] duplicates = animalsRepository.findDuplicate();
            assertEquals(duplicates.length, 2);
            assertEquals(duplicates[0], animals[0]);
            assertEquals(duplicates[1], animals[2]);
        }

        @Test
        @DisplayName("Call findDuplicate with no duplicates")
        void findDuplicateWithNoDuplicates() {
            Animal[] animals = new Animal[4];
            animals[0] = new Cat("breed", "cat1", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            animals[1] = new Cat("breed", "cat2", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            animals[2] = new Cat("breed", "cat3", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            animals[3] = new Cat("breed", "cat4", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            animalsRepository.setAnimals(animals);

            Animal[] duplicates = animalsRepository.findDuplicate();
            assertEquals(duplicates.length, 0);
        }

        @Test
        @DisplayName("Call findDuplicate with mixed duplicates")
        void findDuplicateWithMixedDuplicates() {
            Animal[] animals = new Animal[4];
            animals[0] = new Cat("breed", "cat1", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            animals[1] = new Cat("breed", "cat1", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            animals[2] = new Cat("breed", "cat3", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            animals[3] = new Cat("breed", "cat4", BigDecimal.valueOf(100), "character", LocalDate.of(2000, 1, 1));
            animalsRepository.setAnimals(animals);

            Animal[] duplicates = animalsRepository.findDuplicate();
            assertEquals(duplicates.length, 1);
            assertEquals(duplicates[0], animals[0]);
        }
    }
}
