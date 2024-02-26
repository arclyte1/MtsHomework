package org.example.repository;

import org.example.model.Animal;
import org.example.service.CreateAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@Repository
public class AnimalsRepositoryImpl implements AnimalsRepository {

    @Autowired
    private CreateAnimalService createAnimalService;
    private Animal[] animals;

    @Override
    public String[] findLeapYearNames() {
        Predicate<Animal> leapYearAnimalPredicate = animal -> {
            return animal.getBirthDate() != null && animal.getBirthDate().isLeapYear() && animal.getName() != null;
        };

        // Count animals with leap birth year
        int leapYearAnimalsCount = 0;
        for (Animal animal : animals) {
            if (animal != null && leapYearAnimalPredicate.test(animal))
                leapYearAnimalsCount++;
        }

        // Init and fill result array
        String[] leapYearAnimalNames = new String[leapYearAnimalsCount];
        leapYearAnimalsCount--; // decrement for use as index of leapYearAnimalNames
        for (Animal animal : animals) {
            if (animal != null && leapYearAnimalPredicate.test(animal)) {
                leapYearAnimalNames[leapYearAnimalsCount] = animal.getName();
                leapYearAnimalsCount--;
            }
        }
        return leapYearAnimalNames;
    }

    @Override
    public Animal[] findOlderAnimal(int n) {
        BiPredicate<Animal, LocalDate> olderAnimalPredicate = (animal, date) -> {
            return animal.getBirthDate() != null && animal.getBirthDate().isBefore(date);
        };
        LocalDate maximumBirthDate = LocalDate.now().minusYears(n);

        // Count animals older than n years
        int olderAnimalsCount = 0;
        for (Animal animal : animals) {
            if (animal != null && olderAnimalPredicate.test(animal, maximumBirthDate))
                olderAnimalsCount++;
        }

        // Init and fill result array
        Animal[] olderAnimals = new Animal[olderAnimalsCount];
        olderAnimalsCount--; // decrement for use as index of olderAnimals
        for (Animal animal : animals) {
            if (animal != null && olderAnimalPredicate.test(animal, maximumBirthDate)) {
                olderAnimals[olderAnimalsCount] = animal;
                olderAnimalsCount--;
            }
        }
        return olderAnimals;
    }

    @Override
    public void printDuplicate() {
        Animal[] duplicates = findDuplicate();
        for (Animal animal : duplicates) {
            System.out.println(animal);
        }
    }

    @Override
    public Animal[] findDuplicate() {
        Map<Animal, Integer> counts = new HashMap<>();
        List<Animal> duplicates = new ArrayList<>();
        for (Animal animal : animals) {
            int count = counts.getOrDefault(animal, 0) + 1;
            if (count == 2) {
                duplicates.add(animal);
            }
            counts.put(animal, count);
        }
        return duplicates.toArray(new Animal[0]);
    }

    @Override
    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    @Override
    public Animal[] getAnimals() {
        return this.animals;
    }

    @PostConstruct
    private void postConstruct() {
        animals = createAnimalService.createAnimals();
    }
}
