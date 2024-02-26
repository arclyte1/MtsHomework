package org.example.service;

import org.example.model.Animal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class SearchAnimalServiceImpl implements SearchAnimalService {

    @Override
    public String[] findLeapYearNames(Animal[] animals) {
        Predicate<Animal> leapYearAnimalPredicate = animal -> animal.getBirthDate() != null && animal.getBirthDate().isLeapYear() && animal.getName() != null;

        List<String> leapYearAnimalNames = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal != null && leapYearAnimalPredicate.test(animal)) {
                leapYearAnimalNames.add(animal.getName());
            }
        }
        return leapYearAnimalNames.toArray(String[]::new);
    }

    @Override
    public Animal[] findOlderAnimal(Animal[] animals, int n) {
        BiPredicate<Animal, LocalDate> olderAnimalPredicate = (animal, date) -> animal.getBirthDate() != null && animal.getBirthDate().isBefore(date);
        LocalDate maximumBirthDate = LocalDate.now().minusYears(n);

        List<Animal> olderAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal != null && olderAnimalPredicate.test(animal, maximumBirthDate)) {
                olderAnimals.add(animal);
            }
        }
        return olderAnimals.toArray(Animal[]::new);
    }

    @Override
    public void printDuplicate(Animal[] animals) {
        Animal[] duplicates = findDuplicate(animals);
        for (Animal animal : duplicates) {
            System.out.println(animal);
        }
    }

    @Override
    public Animal[] findDuplicate(Animal[] animals) {
        Map<Animal, Integer> counts = new HashMap<>();
        List<Animal> duplicates = new ArrayList<>();
        for (Animal animal : animals) {
            int count = counts.getOrDefault(animal, 0) + 1;
            if (count == 2) {
                duplicates.add(animal);
            }
            counts.put(animal, count);
        }
        return duplicates.toArray(Animal[]::new);
    }
}
