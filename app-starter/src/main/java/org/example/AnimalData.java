package org.example;

import java.util.Random;

public final class AnimalData {

    private final AnimalDataConfig config;
    private final Random random = new Random();

    public AnimalData(AnimalDataConfig config) {
        this.config = config;
    }

    private String getRandomStringFromConfig(String key) {
        String[] values = config.get(key);
        if (values == null) {
            return null;
        }

        return values[random.nextInt(values.length)];
    }

    public String getRandomName() {
        return getRandomStringFromConfig("names");
    }

    public String getRandomDogBreed() {
        return getRandomStringFromConfig("dogBreeds");
    }

    public String getRandomCatBreed() {
        return getRandomStringFromConfig("catBreeds");
    }

    public String getRandomSharkBreed() {
        return getRandomStringFromConfig("sharkBreeds");
    }

    public String getRandomWolfBreed() {
        return getRandomStringFromConfig("wolfBreeds");
    }

    public String getRandomCharacter() {
        return getRandomStringFromConfig("characters");
    }
}
