package org.example.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class AbstractAnimal implements Animal {

    protected String breed;
    protected String name;
    protected BigDecimal cost;
    protected String character;
    protected LocalDate birthDate;

    public AbstractAnimal(String breed,
                          String name,
                          BigDecimal cost,
                          String character,
                          LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost != null ? cost.setScale(2, RoundingMode.HALF_UP) : null;
        this.character = character;
        this.birthDate = birthDate;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        String birthDatePattern = "dd-MM-yyyy";
        return "AbstractAnimal{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthDate=" + birthDate.format(DateTimeFormatter.ofPattern(birthDatePattern)) +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractAnimal other = (AbstractAnimal) obj;
        return ((name == null && other.name == null) || (name != null && name.equals(other.name)))
                && ((breed == null && other.breed == null) || (breed != null && breed.equals(other.breed)))
                && ((cost == null && other.cost == null) || (cost != null && cost.equals(other.cost)))
                && ((character == null && other.character == null) || (character != null && character.equals(other.character)))
                && ((birthDate == null && other.birthDate == null) || (birthDate != null && birthDate.equals(other.birthDate)));
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((breed == null) ? 0 : breed.hashCode());
        result = prime * result + ((cost == null) ? 0 : cost.hashCode());
        result = prime * result + ((character == null) ? 0 : character.hashCode());
        result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
        return result;
    }
}
