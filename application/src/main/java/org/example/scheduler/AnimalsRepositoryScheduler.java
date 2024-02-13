package org.example.scheduler;

import org.example.repository.AnimalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AnimalsRepositoryScheduler {

    @Autowired
    private AnimalsRepository animalsRepository;

    @Scheduled(fixedRate = 60 * 1000)
    public void printAllRepositoryMethods() {
        System.out.println(Arrays.toString(animalsRepository.findLeapYearNames()));
        System.out.println(Arrays.toString(animalsRepository.findDuplicate()));
        System.out.println(Arrays.toString(animalsRepository.findOlderAnimal(10)));
    }
}
