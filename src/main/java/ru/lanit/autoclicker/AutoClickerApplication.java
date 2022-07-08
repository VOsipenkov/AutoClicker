package ru.lanit.autoclicker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AutoClickerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoClickerApplication.class, args);
    }
}
