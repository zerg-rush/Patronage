package pl.aszul.patronage.bootstrap;

// import org.codehaus.groovy.runtime.powerassert.SourceText;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
// import pl.aszul.patronage.config.SwaggerConfig;
import org.springframework.context.annotation.Conditional;
import pl.aszul.patronage.config.StorageH2SelectedConfig;
import pl.aszul.patronage.config.StorageHashMapSelectedConfig;
import pl.aszul.patronage.domain.*;
import pl.aszul.patronage.domain.enums.FuelType;
import pl.aszul.patronage.domain.enums.Gender;
import pl.aszul.patronage.domain.enums.IDNumberType;
import pl.aszul.patronage.services.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SpringBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    // as requested if H2_STORAGE_ENABLED env var is not set, than it should be considered as true
    @Value("${H2_STORAGE_ENABLED:true}")
    private String H2_STORAGE_ENABLED_ENV;

    // boolean feature toggle as requested in task #2
    private boolean H2_STORAGE_ENABLED;

/*    if (H2_STORAGE_ENABLED) {
        private PersonServiceH2 personService;
        private VehicleServiceH2 vehicleService;
    } else {*/

    private PersonService personService;
    private VehicleService vehicleService;

/*    @Qualifier("HashMapBean")
    private PersonServiceHashMap personService;

    @Qualifier("HashMapBean")
    private VehicleServiceHashMap vehicleService;

    @Qualifier("H2Bean")
    private PersonServiceH2 personService;

    @Qualifier("H2Bean")
    private VehicleServiceH2 vehicleService;*/

    //    }
    private final Logger log = Logger.getLogger(SpringBootstrap.class);
//    private Class<SwaggerDefinition> swaggerDefinitionClass;
    // swaggerDefinitionClass.

    // tried to use @Qualifier annotation
/*    @Autowired
    @Qualifier("HashMapBean")
    public void setPersonService(PersonServiceHashMap personService) {
        this.personService = personService;
    }

    @Autowired
    @Qualifier("HashMapBean")
    public void setVehicleService(VehicleServiceHashMap vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Autowired
    @Qualifier("H2Bean")
    public void setPersonService(PersonServiceH2 personService) {
        this.personService = personService;
    }

    @Autowired
    @Qualifier("H2Bean")
    public void setVehicleService(VehicleServiceH2 vehicleService) {
        this.vehicleService = vehicleService;
    }*/

/*    @Autowired
    @Conditional(StorageHashMapSelectedConfig.class)
    public void setPersonService(PersonServiceHashMap personService) {
        this.personService = personService;
    }

    @Autowired
    @Conditional(StorageHashMapSelectedConfig.class)
    public void setVehicleService(VehicleServiceHashMap vehicleService) {
        this.vehicleService = vehicleService;
    } */

    @Autowired
    //@Conditional(StorageH2SelectedConfig.class)
    public void setPersonService(PersonServiceH2 personService) {
        this.personService = personService;
    }

    @Autowired
    //@Conditional(StorageH2SelectedConfig.class)
    public void setVehicleService(VehicleServiceH2 vehicleService) {
        this.vehicleService = vehicleService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        H2_STORAGE_ENABLED = H2_STORAGE_ENABLED_ENV.equals("true");
        log.info("H2_STORAGE_ENABLED environment variable = " + (System.getenv("H2_STORAGE_ENABLED").isEmpty() ?
                "not set (considered as true)" : H2_STORAGE_ENABLED));
        log.info("Data storage type : " + (H2_STORAGE_ENABLED ? "new H2 database (in memory)" :
                "old basic HashMap object (in memory)"));
        log.info("Swagger2 REST API specification file available to download at http://localhost:8080/v2/api-docs");
        log.info("Swagger2 REST API frontend UI available to browse at http://localhost:8080/swagger-ui.html#/");

        preloadPersons();
        preloadVehicles();
//        swaggerDefinitionClass = SwaggerDefinition.class;
    }

    private void preloadPersons() {
        personService.savePerson(new Person("Trump", "Donald", Gender.MALE, LocalDate.parse("1950-01-01"),
                "613-19-4688", IDNumberType.SSN, 11234567890L, "CEO@whitehouse.gov"));

        personService.savePerson(new Person("Electroda", "Doda", Gender.FEMALE, LocalDate.parse("1985-11-05"),
                "23456789012", IDNumberType.NIP, 49567895432L, "blondi@doda.org"));

        personService.savePerson(new Person("Malinowska", "Agata", Gender.FEMALE, LocalDate.parse("1980-05-05"),
                "987654321", IDNumberType.REGON, 48912223344L, "agata@onet.pl"));

        personService.savePerson(new Person("Kiepski", "Ferdynand", Gender.MALE, LocalDate.parse("1960-10-11"),
                "613-19-4688", IDNumberType.PESEL, 11234567890L, "kiepski@polsat.pl"));

        personService.savePerson(new Person("Zawadzki", "Roman", Gender.MALE, LocalDate.parse("1991-09-04"),
                "23456789012", IDNumberType.PESEL, 48098765432L, "romek.atomek@intive.pl"));

        personService.savePerson(new Person("Go Home", "E.T.", Gender.ALIEN, LocalDate.parse("1980-08-12"),
                "987654321", IDNumberType.PASSPORT, 48912223344L, "ET@space.galactic"));
        log.info("Preloaded six dummy persons");
    }

    private void preloadVehicles() {
        vehicleService.saveVehicle(new Vehicle(2004, "ZS1234", LocalDate.parse("2005-07-01"),
                "SKODA", "X6", "5GAER23D89J184215", LocalDate.parse("2005-07-02"),
                4200, 320_000, FuelType.DIESEL));

        vehicleService.saveVehicle(new Vehicle(2004, "ZS2345", LocalDate.parse("2005-07-01"),
                "HONDA", "MONDEO", "1FAHP53U22G143588", LocalDate.parse("2005-07-04"),
                2300, 160_000, FuelType.DIESEL));

        vehicleService.saveVehicle(new Vehicle(2004, "ZS3456", LocalDate.parse("2005-07-01"),
                "FIAT", "P100D", "JTLKE50E791087958", LocalDate.parse("2005-07-05"),
                50, 300_000, FuelType.ELECTRIC));

        vehicleService.saveVehicle(new Vehicle(2007, "ZS4567", LocalDate.parse("2008-07-01"),
                "SKODA", "V50", "1C4RJECG1FC734860", LocalDate.parse("2009-07-06"),
                4200, 320_000, FuelType.GASOLINE));

        vehicleService.saveVehicle(new Vehicle(2003, "WN5678", LocalDate.parse("2004-07-01"),
                "HONDA", "MONDEO", "5YFBURHE5FP261348", LocalDate.parse("2004-07-09"),
                2300, 160_000, FuelType.DIESEL));

        vehicleService.saveVehicle(new Vehicle(2001, "ZS6789", LocalDate.parse("2002-07-01"),
                "FIAT", "X6", "1FMZU73K25UA86862", LocalDate.parse("2002-08-03"),
                5000, 400_000, FuelType.HYBRID));
        log.info("Preloaded six dummy vehicles");
    }
}