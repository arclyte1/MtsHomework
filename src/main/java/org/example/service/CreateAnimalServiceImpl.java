package org.example.service;

import org.example.utils.RandomAnimalProvider;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    @Override
    public void createAnimals() {
        RandomAnimalProvider animalProvider = RandomAnimalProvider.getInstance();
        int i = 0;
        do {
            System.out.println(animalProvider.provide());
            i++;
        } while (i < 10);
    }

    public void createAnimals(int n) {
        RandomAnimalProvider animalProvider = RandomAnimalProvider.getInstance();
        for (int i = 0; i < n; i++) {
            System.out.println(animalProvider.provide());
        }
    }
}
