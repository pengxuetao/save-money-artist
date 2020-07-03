package com.luffy.artist;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用启动类
 *
 * @author Peng xue-tao
 * @since 2020/6/17
 */
@MapperScan("com.luffy.artist.dao")
@SpringBootApplication
public class ArtistApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtistApplication.class, args);
    }

}
