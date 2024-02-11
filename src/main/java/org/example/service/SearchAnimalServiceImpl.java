package org.example.service;

import org.example.model.Animal;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class SearchAnimalServiceImpl implements SearchAnimalService {

    @Override
    public String[] findLeapYearNames(Animal[] animals) {
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
    public Animal[] findOlderAnimal(Animal[] animals, int n) {
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
    public void findDuplicate(Animal[] animals) {
        Map<Animal, Integer> counts = new HashMap<>();
        for (Animal animal : animals) {
            counts.put(animal, counts.getOrDefault(animal, 0) + 1);
        }
        counts.forEach((animal, count) -> {
            if (animal != null && count > 1) {
                System.out.println(animal);
            }
        });
    }
}
