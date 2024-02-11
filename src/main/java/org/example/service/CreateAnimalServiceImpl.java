package org.example.service;

import org.example.model.Animal;
import org.example.model.AnimalType;
import org.example.utils.RandomAnimalProvider;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    @Override
    public Animal[] createAnimals(AnimalType[] types) {
        RandomAnimalProvider animalProvider = RandomAnimalProvider.getInstance();
        Animal[] animals = new Animal[10];
        int i = 0;
        do {
            animals[i] = animalProvider.provide(types);
            i++;
        } while (i < 10);
        return animals;
    }

    /**
     * Creates n random {@link Animal}s provided by {@link RandomAnimalProvider}
     *
     * @param types array of possible {@link AnimalType}s to create
     * @param n     number of animals to create
     * @return array of created animals
     */
    public Animal[] createAnimals(AnimalType[] types, int n) {
        RandomAnimalProvider animalProvider = RandomAnimalProvider.getInstance();
        Animal[] animals = new Animal[n];
        for (int i = 0; i < n; i++) {
            animals[i] = animalProvider.provide(types);
        }
        return animals;
    }
}
