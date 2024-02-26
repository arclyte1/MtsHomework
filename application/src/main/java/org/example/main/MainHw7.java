package org.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "org.example")
@EnableScheduling
public class MainHw7 {

    public static void main(String[] args) {
        SpringApplication.run(MainHw7.class, args);
    }
}
