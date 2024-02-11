package org.example.service;

import org.example.model.Animal;

public interface SearchAnimalService {

    /**
     * Finds animals with leap birth year and returns their names. Also filters out null names.
     *
     * @param animals array of animals
     * @return array of names of animals with leap birth year
     */
    String[] findLeapYearNames(Animal[] animals);

    /**
     * Finds animals older than n years.
     *
     * @param animals array of animals
     * @param n       minimum age years
     * @return array of found animals
     */
    Animal[] findOlderAnimal(Animal[] animals, int n);

    /**
     * Finds animal duplicates using {@link Object#equals(Object)} and prints them.
     *
     * @param animals array of animals
     */
    void printDuplicate(Animal[] animals);

    /**
     * Finds animal duplicates using {@link Object#equals(Object)} and returns them.
     *
     * @param animals array of animals
     * @return array of duplicates
     */
    Animal[] findDuplicate(Animal[] animals);
}
