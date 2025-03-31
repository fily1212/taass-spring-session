package it.unito.jpasession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class JpaSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaSessionApplication.class, args);
    }

}
