package ru.lanit.autoclicker.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import static java.awt.event.KeyEvent.*;

@Slf4j
@Service
@RequiredArgsConstructor
class ClickService {
    private final Robot robot;

    @Scheduled(fixedRate = 60_000)
    public void doAction() throws InterruptedException, IOException {
        LocalDateTime startTime = LocalDateTime.now();
        Thread.sleep(10_000);
        readLines().forEach(this::typeLine);
        LocalDateTime endTime = LocalDateTime.now();

        log.info("Finished, execution time {}", ChronoUnit.MINUTES.between(startTime, endTime));
    }

    public List<String> readLines() throws IOException {
        File file = new File("template.txt");
        return FileUtils.readLines(file, Charset.defaultCharset()).stream()
            .map(String::toLowerCase)
            .collect(Collectors.toList());
    }

    public void typeLine(String line) {
        try {
            char[] arr = line.trim().toCharArray();
            for (char ch : arr) {
                int key = map(ch);
                robot.keyPress(key);
                robot.keyRelease(key);
                Thread.sleep(300);
            }
            Thread.sleep(5_000);
        } catch (Exception e) {
            log.error("Ошибка во время ввода строки");
        }
    }

    private int map(char character) {
        switch (character) {
            case 'a':
                return (VK_A);
            case 'b':
                return (VK_B);
            case 'c':
                return (VK_C);
            case 'd':
                return (VK_D);
            case 'e':
                return (VK_E);
            case 'f':
                return (VK_F);
            case 'g':
                return (VK_G);
            case 'h':
                return (VK_H);
            case 'i':
                return (VK_I);
            case 'j':
                return (VK_J);
            case 'k':
                return (VK_K);
            case 'l':
                return (VK_L);
            case 'm':
                return (VK_M);
            case 'n':
                return (VK_N);
            case 'o':
                return (VK_O);
            case 'p':
                return (VK_P);
            case 'q':
                return (VK_Q);
            case 'r':
                return (VK_R);
            case 's':
                return (VK_S);
            case 't':
                return (VK_T);
            case 'u':
                return (VK_U);
            case 'v':
                return (VK_V);
            case 'w':
                return (VK_W);
            case 'x':
                return (VK_X);
            case 'y':
                return (VK_Y);
            case 'z':
                return (VK_Z);
            case '0':
                return (VK_0);
            case '1':
                return (VK_1);
            case '2':
                return (VK_2);
            case '3':
                return (VK_3);
            case '4':
                return (VK_4);
            case '5':
                return (VK_5);
            case '6':
                return (VK_6);
            case '7':
                return (VK_7);
            case '8':
                return (VK_8);
            case '9':
                return (VK_9);
            case '-':
                return (VK_MINUS);
            case '=':
                return (VK_EQUALS);
            case ';':
                return (VK_SEMICOLON);
            default:
                return (VK_ENTER);
        }
    }
}