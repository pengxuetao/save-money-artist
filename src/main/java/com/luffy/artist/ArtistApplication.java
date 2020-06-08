package com.luffy.artist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ArtistApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtistApplication.class, args);
    }

}
