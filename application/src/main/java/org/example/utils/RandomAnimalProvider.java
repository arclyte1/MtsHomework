package org.example.utils;

import org.example.AnimalData;
import org.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;

@Component
public final class RandomAnimalProvider {

    @Autowired
    private AnimalData animalData;
    private static final int MIN_COST = 1;
    private static final int MAX_COST = 5000;
    private static final long MIN_BIRTH_DATE_EPOCH_MILLIS = 0;
    private static final long MAX_BIRTH_DATE_EPOCH_MILLIS = Instant.now().toEpochMilli();

    private final Random random = new Random();

    private Cat provideCat() {
        return new Cat(
                animalData.getRandomCatBreed(),
                animalData.getRandomName(),
                BigDecimal.valueOf(random.nextDouble(MIN_COST, MAX_COST)),
                animalData.getRandomCharacter(),
                LocalDate.ofInstant(Instant.ofEpochMilli(random.nextLong(
                        MIN_BIRTH_DATE_EPOCH_MILLIS,
                        MAX_BIRTH_DATE_EPOCH_MILLIS
                )), ZoneId.systemDefault())
        );
    }

    private Dog provideDog() {
        return new Dog(
                animalData.getRandomDogBreed(),
                animalData.getRandomName(),
                BigDecimal.valueOf(random.nextDouble(MIN_COST, MAX_COST)),
                animalData.getRandomCharacter(),
                LocalDate.ofInstant(Instant.ofEpochMilli(random.nextLong(
                        MIN_BIRTH_DATE_EPOCH_MILLIS,
                        MAX_BIRTH_DATE_EPOCH_MILLIS
                )), ZoneId.systemDefault())
        );
    }

    private Shark provideShark() {
        return new Shark(
                animalData.getRandomSharkBreed(),
                animalData.getRandomName(),
                BigDecimal.valueOf(random.nextDouble(MIN_COST, MAX_COST)),
                animalData.getRandomCharacter(),
                LocalDate.ofInstant(Instant.ofEpochMilli(random.nextLong(
                        MIN_BIRTH_DATE_EPOCH_MILLIS,
                        MAX_BIRTH_DATE_EPOCH_MILLIS
                )), ZoneId.systemDefault())
        );
    }

    private Wolf provideWolf() {
        return new Wolf(
                animalData.getRandomWolfBreed(),
                animalData.getRandomName(),
                BigDecimal.valueOf(random.nextDouble(MIN_COST, MAX_COST)),
                animalData.getRandomCharacter(),
                LocalDate.ofInstant(Instant.ofEpochMilli(random.nextLong(
                        MIN_BIRTH_DATE_EPOCH_MILLIS,
                        MAX_BIRTH_DATE_EPOCH_MILLIS
                )), ZoneId.systemDefault())
        );
    }

    private Animal provideOfType(AnimalType type) {
        switch (type) {
            case CAT -> {
                return provideCat();
            }
            case DOG -> {
                return provideDog();
            }
            case WOLF -> {
                return provideWolf();
            }
            case SHARK -> {
                return provideShark();
            }
        }
        return null;
    }

    /**
     * Provides random animal of one of the specified types
     *
     * @param types array of possible {@link AnimalType}s to generate
     * @return random {@link Animal} or null if types array is empty
     */
    public Animal provide(AnimalType[] types) {
        if (types.length == 0) {
            return null;
        }
        int randomIndex = random.nextInt(types.length);
        return provideOfType(types[randomIndex]);
    }
}
