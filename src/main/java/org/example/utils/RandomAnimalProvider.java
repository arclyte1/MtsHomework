package org.example.utils;

import org.example.model.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;

public final class RandomAnimalProvider {

    private static final RandomAnimalProvider INSTANCE = new RandomAnimalProvider();
    private static final String[] ANIMAL_NAMES = new String[]{
            "Бадди",
            "Бакстер",
            "Джейк",
            "Дэйзи",
            "Купер",
            "Люк",
            "Макс",
            "Оливер",
            "Рокки",
            "Чарли"
    };
    private static final String[] DOG_BREEDS = new String[]{
            "Аффенпинчер",
            "Бостон-терьер",
            "Вельштерьер",
            "Мопс"
    };
    private static final String[] CAT_BREEDS = new String[]{
            "Британская короткошерстная",
            "Мейн-Кун",
            "Азиатская кошка",
            "Манчкин"
    };
    private static final String[] SHARK_BREEDS = new String[]{
            "Молотоголовая акула",
            "Белая акула",
            "Японский пилонос",
            "Чёрная колючая акула"
    };
    private static final String[] WOLF_BREEDS = new String[]{
            "Гривистый волк",
            "Лирый Волк",
            "Красный волк",
            "Макензенский Волк"
    };
    private static final String[] CHARACTERS = new String[]{
            "Слишком дружелюбный",
            "Нервный",
            "Обычный",
            "Своенравный",
            "Робкий"
    };
    private static final int MIN_COST = 1;
    private static final int MAX_COST = 5000;
    private static final long MIN_BIRTH_DATE_EPOCH_MILLIS = 0;
    private static final long MAX_BIRTH_DATE_EPOCH_MILLIS = Instant.now().toEpochMilli();

    private final Random random = new Random();

    public static RandomAnimalProvider getInstance() {
        return INSTANCE;
    }

    private RandomAnimalProvider() {
    }

    private Cat provideCat() {
        return new Cat(
                CAT_BREEDS[random.nextInt(CAT_BREEDS.length)],
                ANIMAL_NAMES[random.nextInt(ANIMAL_NAMES.length)],
                BigDecimal.valueOf(random.nextDouble(MIN_COST, MAX_COST)),
                CHARACTERS[random.nextInt(CHARACTERS.length)],
                LocalDate.ofInstant(Instant.ofEpochMilli(random.nextLong(
                        MIN_BIRTH_DATE_EPOCH_MILLIS,
                        MAX_BIRTH_DATE_EPOCH_MILLIS
                )), ZoneId.systemDefault())
        );
    }

    private Dog provideDog() {
        return new Dog(
                DOG_BREEDS[random.nextInt(DOG_BREEDS.length)],
                ANIMAL_NAMES[random.nextInt(ANIMAL_NAMES.length)],
                BigDecimal.valueOf(random.nextDouble(MIN_COST, MAX_COST)),
                CHARACTERS[random.nextInt(CHARACTERS.length)],
                LocalDate.ofInstant(Instant.ofEpochMilli(random.nextLong(
                        MIN_BIRTH_DATE_EPOCH_MILLIS,
                        MAX_BIRTH_DATE_EPOCH_MILLIS
                )), ZoneId.systemDefault())
        );
    }

    private Shark provideShark() {
        return new Shark(
                SHARK_BREEDS[random.nextInt(SHARK_BREEDS.length)],
                ANIMAL_NAMES[random.nextInt(ANIMAL_NAMES.length)],
                BigDecimal.valueOf(random.nextDouble(MIN_COST, MAX_COST)),
                CHARACTERS[random.nextInt(CHARACTERS.length)],
                LocalDate.ofInstant(Instant.ofEpochMilli(random.nextLong(
                        MIN_BIRTH_DATE_EPOCH_MILLIS,
                        MAX_BIRTH_DATE_EPOCH_MILLIS
                )), ZoneId.systemDefault())
        );
    }

    private Wolf provideWolf() {
        return new Wolf(
                WOLF_BREEDS[random.nextInt(WOLF_BREEDS.length)],
                ANIMAL_NAMES[random.nextInt(ANIMAL_NAMES.length)],
                BigDecimal.valueOf(random.nextDouble(MIN_COST, MAX_COST)),
                CHARACTERS[random.nextInt(CHARACTERS.length)],
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
