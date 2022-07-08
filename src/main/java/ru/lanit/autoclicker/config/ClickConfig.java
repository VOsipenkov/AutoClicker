package ru.lanit.autoclicker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

@Configuration
public class ClickConfig {
    @Bean
    Robot robot() throws AWTException {
        System.setProperty("java.awt.headless", "false");
        return new Robot();
    }
}
