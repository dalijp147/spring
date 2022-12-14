package tn.esprit.projetkaddem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProjetKaddemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetKaddemApplication.class, args);
    }

}
