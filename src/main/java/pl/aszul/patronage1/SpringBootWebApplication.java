package pl.aszul.patronage1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import pl.aszul.patronage1.bootstrap.SpringBootstrap;
import pl.aszul.patronage1.controllers.PersonController;
import pl.aszul.patronage1.controllers.VehicleController;
import pl.aszul.patronage1.services.PersonService;
import pl.aszul.patronage1.services.VehicleService;

@SpringBootApplication
@ComponentScan(basePackageClasses=PersonController.class)
@ComponentScan(basePackageClasses=VehicleController.class)
@ComponentScan(basePackageClasses=SpringBootstrap.class)
@ComponentScan(basePackageClasses=PersonService.class)
@ComponentScan(basePackageClasses=VehicleService.class)
public class SpringBootWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}


