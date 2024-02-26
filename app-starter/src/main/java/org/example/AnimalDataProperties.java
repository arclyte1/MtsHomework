package org.example;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application.animal-data")
public class AnimalDataProperties {

    private String[] names;
    private String[] dogBreeds;
    private String[] catBreeds;
    private String[] sharkBreeds;
    private String[] wolfBreeds;
    private String[] characters;

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public String[] getDogBreeds() {
        return dogBreeds;
    }

    public void setDogBreeds(String[] dogBreeds) {
        this.dogBreeds = dogBreeds;
    }

    public String[] getCatBreeds() {
        return catBreeds;
    }

    public void setCatBreeds(String[] catBreeds) {
        this.catBreeds = catBreeds;
    }

    public String[] getSharkBreeds() {
        return sharkBreeds;
    }

    public void setSharkBreeds(String[] sharkBreeds) {
        this.sharkBreeds = sharkBreeds;
    }

    public String[] getWolfBreeds() {
        return wolfBreeds;
    }

    public void setWolfBreeds(String[] wolfBreeds) {
        this.wolfBreeds = wolfBreeds;
    }

    public String[] getCharacters() {
        return characters;
    }

    public void setCharacters(String[] characters) {
        this.characters = characters;
    }
}
