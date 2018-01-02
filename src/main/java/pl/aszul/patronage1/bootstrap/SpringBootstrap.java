package pl.aszul.patronage1.bootstrap;

import pl.aszul.patronage1.domain.Person;
import pl.aszul.patronage1.domain.Vehicle;
import pl.aszul.patronage1.services.PersonServiceImpl;
import pl.aszul.patronage1.services.VehicleServiceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SpringBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private PersonServiceImpl personService;
    private VehicleServiceImpl vehicleService;

    private final Logger log = Logger.getLogger(SpringBootstrap.class);

    @Autowired
    public void setPersonService(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @Autowired
    public void setVehicleService(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        preloadPersons();
        preloadVehicles();
    }

    private void preloadPersons() {
        personService.savePerson(new Person("Trump", "Donald", "M", "01.01.1950",
                "613-19-4688","SSN", "011234567890", "CEO@whitehouse.gov"));

        personService.savePerson(new Person("Zawadzki", "Roman", "M","05.07.1991",
                "23456789012","PESEL", "48098765432", "CEO@whitehouse.gov"));

        personService.savePerson(new Person("Malinowska", "Agata", "K","05.05.1980",
                "987654321","REGON", "48912223344", "CEO@whitehouse.gov"));

        personService.savePerson(new Person("Trump", "Donald", "M", "01.01.1950",
                "613-19-4688","SSN", "011234567890", "CEO@whitehouse.gov"));

        personService.savePerson(new Person("Zawadzki", "Roman", "M","05.07.1991",
                "23456789012","PESEL", "48098765432", "CEO@whitehouse.gov"));

        personService.savePerson(new Person("Malinowska", "Agata", "K","05.05.1980",
                "987654321","REGON", "48912223344", "CEO@whitehouse.gov"));
        log.info("Preloaded six dummy persons");
    }

    private void preloadVehicles() {
        vehicleService.saveVehicle(new Vehicle(2001, "ZS 1234A", "01.07.2005",
                "BMW", "X6", "5GAER23D89J184215", "06.11.2013",
                4200, 320_000, "P"));

        vehicleService.saveVehicle(new Vehicle(2002, "ZS 2345A", "01.07.2005",
                "FORD", "MONDEO", "1FAHP53U22G143588", "06.11.2013",
                2300, 160_000, "D"));

        vehicleService.saveVehicle(new Vehicle(2003, "ZS 3456A", "01.07.2005",
                "TESLA", "P100D", "JTLKE50E791087958", "06.11.2013",
                0, 300_000, "E"));

        vehicleService.saveVehicle(new Vehicle(2004, "ZS 4567A", "01.07.2008",
                "Volvo", "V50", "1C4RJECG1FC734860", "06.11.2013",
                4200, 320_000, "P"));

        vehicleService.saveVehicle(new Vehicle(2005, "WN 5678A", "01.07.2005",
                "KAWASAKI", "MONDEO", "5YFBURHE5FP261348", "06.11.2013",
                2300, 160_000, "D"));

        vehicleService.saveVehicle(new Vehicle(2006, "ZS 6789A", "01.07.2005",
                "JELCZ", "X6", "1FMZU73K25UA86862", "06.11.2013",
                5000, 400_000, "D"));
        log.info("Preloaded six dummy vehicles");
    }
}