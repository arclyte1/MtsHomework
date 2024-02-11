package org.example.utils;

import org.example.model.*;

import java.math.BigDecimal;
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
                CHARACTERS[random.nextInt(CHARACTERS.length)]
        );
    }

    private Dog provideDog() {
        return new Dog(
                DOG_BREEDS[random.nextInt(DOG_BREEDS.length)],
                ANIMAL_NAMES[random.nextInt(ANIMAL_NAMES.length)],
                BigDecimal.valueOf(random.nextDouble(MIN_COST, MAX_COST)),
                CHARACTERS[random.nextInt(CHARACTERS.length)]
        );
    }

    private Shark provideShark() {
        return new Shark(
                SHARK_BREEDS[random.nextInt(SHARK_BREEDS.length)],
                ANIMAL_NAMES[random.nextInt(ANIMAL_NAMES.length)],
                BigDecimal.valueOf(random.nextDouble(MIN_COST, MAX_COST)),
                CHARACTERS[random.nextInt(CHARACTERS.length)]
        );
    }

    private Wolf provideWolf() {
        return new Wolf(
                WOLF_BREEDS[random.nextInt(WOLF_BREEDS.length)],
                ANIMAL_NAMES[random.nextInt(ANIMAL_NAMES.length)],
                BigDecimal.valueOf(random.nextDouble(MIN_COST, MAX_COST)),
                CHARACTERS[random.nextInt(CHARACTERS.length)]
        );
    }

    public Animal provide() {
        switch (random.nextInt(4)) {
            case 0 -> {
                return provideCat();
            }
            case 1 -> {
                return provideDog();
            }
            case 2 -> {
                return provideShark();
            }
            case 3 -> {
                return provideWolf();
            }
        }
        return null;
    }
}
