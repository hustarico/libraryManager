package com.hustarico;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.hustarico")
public class LibraryManager {
    public static void main(String[] args) {
        SpringApplication.run(LibraryManager.class, args);
    }
}