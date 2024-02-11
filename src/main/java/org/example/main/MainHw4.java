package org.example.main;

import org.example.model.Animal;
import org.example.model.AnimalType;
import org.example.service.CreateAnimalService;
import org.example.service.CreateAnimalServiceImpl;
import org.example.service.SearchAnimalService;
import org.example.service.SearchAnimalServiceImpl;

import java.util.Arrays;

public class MainHw4 {

    public static void main(String[] args) {
        AnimalType[] animalTypesToCreate = new AnimalType[]{
                AnimalType.DOG,
                AnimalType.CAT,
                AnimalType.SHARK,
                AnimalType.WOLF
        };

        CreateAnimalService createService = new CreateAnimalService() { };
        Animal[] animals = createService.createAnimals(animalTypesToCreate);

        CreateAnimalServiceImpl createServiceImpl = new CreateAnimalServiceImpl();
        Animal[] animals2 = createServiceImpl.createAnimals(animalTypesToCreate);
        Animal[] animals3 = Arrays.copyOf(createServiceImpl.createAnimals(animalTypesToCreate, 15), 20);
        for (int i = 0; i < 5; i++) {
            animals3[15 + i] = animals3[i];
        }

        SearchAnimalService searchService = new SearchAnimalServiceImpl();
        System.out.println(Arrays.toString(searchService.findLeapYearNames(animals)));
        System.out.println(Arrays.toString(searchService.findOlderAnimal(animals2, 20)));
        searchService.findDuplicate(animals3);
    }
}
