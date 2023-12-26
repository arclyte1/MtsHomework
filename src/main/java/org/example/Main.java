package org.example;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        AnimalType[] animalTypesToCreate = new AnimalType[] {
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

    public static void printFinalCost(Purchase purchase) {
        BigDecimal finalCostWithoutDiscount = purchase.getProductCost().multiply(BigDecimal.valueOf(purchase.getProductCount()));

        BigDecimal discountMultiplier = BigDecimal.valueOf(1).subtract(purchase.getDiscount().movePointLeft(2));
        BigDecimal finalCostWithDiscount = finalCostWithoutDiscount.multiply(discountMultiplier);

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
        System.out.println("Final cost without discount = " + numberFormat.format(finalCostWithoutDiscount));
        System.out.println("Final cost with discount = " + numberFormat.format(finalCostWithDiscount));
    }
}