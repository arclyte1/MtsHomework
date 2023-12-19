package org.example;

import java.math.BigDecimal;

public abstract class Pet extends AbstractAnimal {

    Pet(String breed, String name, BigDecimal cost, String character) {
        super(breed, name, cost, character);
    }
}
