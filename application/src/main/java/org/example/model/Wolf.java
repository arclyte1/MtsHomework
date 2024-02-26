package org.example.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Wolf extends Predator {

    public Wolf(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
