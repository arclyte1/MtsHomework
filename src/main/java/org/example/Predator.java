package org.example;

import java.math.BigDecimal;

public abstract class Predator extends AbstractAnimal {

    Predator(String breed, String name, BigDecimal cost, String character) {
        super(breed, name, cost, character);
    }
}
