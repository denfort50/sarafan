package ru.letscode.sarafan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SarafanApplication {

    public static void main(String[] args) {
        SpringApplication.run(SarafanApplication.class, args);
        System.out.println("Go to http://localhost:8080/");
    }

}
