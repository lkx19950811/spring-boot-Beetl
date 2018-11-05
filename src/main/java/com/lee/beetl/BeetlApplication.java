package com.lee.beetl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author lee
 */
@SpringBootApplication
@ImportResource(locations = "classpath*:/*.sql")
public class BeetlApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeetlApplication.class, args);
    }
}
