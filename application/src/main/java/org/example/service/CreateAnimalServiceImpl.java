package org.example.service;

import org.example.model.Animal;
import org.example.model.AnimalType;
import org.example.utils.RandomAnimalProvider;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    @Autowired
    private RandomAnimalProvider animalProvider;
    private AnimalType animalType;

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    @Override
    public Animal[] createAnimals() {
        Animal[] animals = new Animal[10];
        int i = 0;
        do {
            animals[i] = animalProvider.provide(new AnimalType[]{animalType});
            i++;
        } while (i < 10);
        return animals;
    }

    /**
     * Creates n random {@link Animal}s provided by {@link RandomAnimalProvider}
     *
     * @param n     number of animals to create
     * @return array of created animals
     */
    public Animal[] createAnimals(int n) {
        Animal[] animals = new Animal[n];
        for (int i = 0; i < n; i++) {
            animals[i] = animalProvider.provide(new AnimalType[]{animalType});
        }
        return animals;
    }
}
