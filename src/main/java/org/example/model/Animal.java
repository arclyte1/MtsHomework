package org.example.model;

import java.math.BigDecimal;

public interface Animal {

    /**
     * @return breed field
     */
    String getBreed();

    /**
     * @return name field
     */
    String getName();

    /**
     * @return cost field
     */
    BigDecimal getCost();

    /**
     * @return character field
     */
    String getCharacter();
}
