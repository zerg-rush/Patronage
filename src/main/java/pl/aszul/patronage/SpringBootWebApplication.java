package pl.aszul.patronage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import pl.aszul.patronage.bootstrap.SpringBootstrap;
import pl.aszul.patronage.controllers.PersonController;
import pl.aszul.patronage.controllers.VehicleController;
import pl.aszul.patronage.repositories.VehicleRepository;
import pl.aszul.patronage.services.PersonService;
import pl.aszul.patronage.services.VehicleService;

@SpringBootApplication
@ComponentScan(basePackageClasses=PersonController.class)
@ComponentScan(basePackageClasses=VehicleController.class)
@ComponentScan(basePackageClasses=SpringBootstrap.class)
@ComponentScan(basePackageClasses=PersonService.class)
@ComponentScan(basePackageClasses=VehicleService.class)
@ComponentScan(basePackageClasses= VehicleRepository.class)
public class SpringBootWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}


