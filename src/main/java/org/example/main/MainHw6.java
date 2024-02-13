package org.example.main;

import org.example.repository.AnimalsRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@ComponentScan("org.example")
public class MainHw6 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainHw6.class);
        AnimalsRepository animalsRepository = context.getBean(AnimalsRepository.class);
        System.out.println(Arrays.toString(animalsRepository.findLeapYearNames()));
        System.out.println(Arrays.toString(animalsRepository.findDuplicate()));
        System.out.println(Arrays.toString(animalsRepository.findOlderAnimal(10)));
    }
}
