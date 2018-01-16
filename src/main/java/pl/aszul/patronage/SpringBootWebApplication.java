package pl.aszul.patronage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import pl.aszul.patronage.bootstrap.SpringBootstrap;
import pl.aszul.patronage.controllers.PersonController;
import pl.aszul.patronage.controllers.VehicleController;
import pl.aszul.patronage.repositories.VehicleCrudRepository;
import pl.aszul.patronage.services.PersonService;
import pl.aszul.patronage.services.VehicleService;
//import pl.aszul.patronage.services.VehicleServiceH2;
//import pl.aszul.patronage.services.VehicleServiceHashMap;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackageClasses=PersonController.class)
@ComponentScan(basePackageClasses=VehicleController.class)
@ComponentScan(basePackageClasses=SpringBootstrap.class)
@ComponentScan(basePackageClasses=PersonService.class)
@ComponentScan(basePackageClasses=VehicleService.class)
//@ComponentScan(basePackageClasses=VehicleServiceH2.class)
//@ComponentScan(basePackageClasses=VehicleServiceHashMap.class)
@ComponentScan(basePackageClasses=VehicleCrudRepository.class)
public class SpringBootWebApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootWebApplication.class, args);

        String[] beans = context.getBeanNamesForType(PersonService.class);
        System.out.println("PersonService beans = " + Arrays.toString(beans));

        context.close();
    }
}


