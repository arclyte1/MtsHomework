package org.example.repository;

import org.example.model.Animal;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsRepository {

    /**
     * Finds animals with leap birth year and returns their names. Also filters out null names.
     *
     * @return array of names of animals with leap birth year
     */
    String[] findLeapYearNames();

    /**
     * Finds animals older than n years.
     *
     * @param n minimum age years
     * @return array of found animals
     */
    Animal[] findOlderAnimal(int n);

    /**
     * Finds animal duplicates using {@link Object#equals(Object)} and prints them.
     */
    void printDuplicate();

    /**
     * Finds animal duplicates using {@link Object#equals(Object)} and returns them.
     *
     * @return array of duplicates
     */
    Animal[] findDuplicate();

    /**
     * Setter for inner animals storage
     *
     * @param animals array of {@link Animal}s
     */
    void setAnimals(Animal[] animals);

    /**
     * Getter for inner animals storage
     *
     * @return array of {@link Animal}s
     */
    Animal[] getAnimals();
}
