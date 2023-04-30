package com.example.dampouring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableScheduling
@SpringBootApplication
@EnableSwagger2
@EnableAsync
public class DamPouringApplication {

    public static void main(String[] args) {
        SpringApplication.run(DamPouringApplication.class, args);
    }

}
