package com.kafka.artist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ArtistApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtistApplication.class, args);
    }

}
