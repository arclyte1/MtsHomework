package org.example.service;

import org.example.utils.RandomAnimalProvider;
import org.example.model.Animal;

public interface CreateAnimalService {

    /**
     * Creates and prints 10 random {@link Animal}s provided by {@link RandomAnimalProvider}
     */
    default void createAnimals() {
        RandomAnimalProvider animalProvider = RandomAnimalProvider.getInstance();
        int i = 0;
        while (i < 10) {
            System.out.println(animalProvider.provide());
            i++;
        }
    }
}
