package org.example.main;

import org.example.service.CreateAnimalService;
import org.example.service.CreateAnimalServiceImpl;

public class MainHw3 {

    public static void main(String[] args) {
        CreateAnimalService service = new CreateAnimalService() { };
        service.createAnimals();

        CreateAnimalServiceImpl serviceImpl = new CreateAnimalServiceImpl();
        serviceImpl.createAnimals();
        serviceImpl.createAnimals(15);
    }
}
