package org.example.service;

import org.example.model.Animal;
import org.example.model.AnimalType;
import org.example.utils.RandomAnimalProvider;

public interface CreateAnimalService {

    /**
     * Creates 10 random {@link Animal}s provided by {@link RandomAnimalProvider}
     *
     * @param types array of possible {@link AnimalType}s to create
     * @return array of created animals
     */
    default Animal[] createAnimals() {
        RandomAnimalProvider animalProvider = RandomAnimalProvider.getInstance();
        Animal[] animals = new Animal[10];
        int i = 0;
        while (i < 10) {
            animals[i] = animalProvider.provide(AnimalType.values());
            i++;
        }
        return animals;
    }
}
