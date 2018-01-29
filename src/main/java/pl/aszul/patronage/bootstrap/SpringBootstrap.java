package pl.aszul.patronage.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import org.apache.log4j.Logger;
import pl.aszul.patronage.domain.enums.FuelType;
import pl.aszul.patronage.domain.enums.Gender;
import pl.aszul.patronage.domain.enums.IDNumberType;
import pl.aszul.patronage.domain.Person;
import pl.aszul.patronage.domain.Vehicle;

@Component
public class SpringBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    // as requested if H2_STORAGE_ENABLED env var is not set, than it should be considered as true
    @Value("${H2_STORAGE_ENABLED:true}")
    private String h2StorageEnabledString;

    private final Logger log = Logger.getLogger(SpringBootstrap.class);

    // boolean feature toggle as requested in task #2
    public static boolean h2StorageEnabled;

    @Autowired
    CrudRepository<Person,Integer> personRepository;

    @Autowired
    CrudRepository<Vehicle, Integer> vehicleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        h2StorageEnabled = h2StorageEnabledString.equals("true");
        log.info("###################################### INTIVE PATRONAGE BACKEND ######################################");
        log.info("H2_STORAGE_ENABLED environment variable = " + (System.getenv("H2_STORAGE_ENABLED") == null ?
                "not set (considered as TRUE)" : h2StorageEnabled));
        log.info("Data storage type : " + (h2StorageEnabled ? "new H2 database (in memory)" :
                "old basic HashMap object (in memory)"));
        log.info("Swagger2 REST API specification file available to download at http://localhost:8080" +
                (System.getProperty("springfox.documentation.swagger.v2.path") == null ? "/v2/api-docs" :
                System.getProperty("springfox.documentation.swagger.v2.path")));
        log.info("Swagger2 REST API frontend UI available to browse at http://localhost:8080/swagger-ui.html#/");

        personRepository.save(new Person("Trump", "Donald", Gender.MALE, LocalDate.parse("1950-01-01"),
                "613-19-4688", IDNumberType.SSN, 11234567890L, "CEO@whitehouse.gov"));

        personRepository.save(new Person("Electroda", "Doda", Gender.FEMALE, LocalDate.parse("1985-11-05"),
                "23456789012", IDNumberType.NIP, 49567895432L, "blondi@doda.org"));

        personRepository.save(new Person("Malinowska", "Agata", Gender.FEMALE, LocalDate.parse("1980-05-05"),
                "987654321", IDNumberType.REGON, 48912223344L, "agata@onet.pl"));

        personRepository.save(new Person("Kiepski", "Ferdynand", Gender.MALE, LocalDate.parse("1960-10-11"),
                "613-19-4688", IDNumberType.PESEL, 11234567890L, "kiepski@polsat.pl"));

        personRepository.save(new Person("Zawadzki", "Roman", Gender.MALE, LocalDate.parse("1991-09-04"),
                "23456789012", IDNumberType.PESEL, 48098765432L, "romek.atomek@intive.pl"));

        personRepository.save(new Person("Go Home", "E.T.", Gender.ALIEN, LocalDate.parse("1980-08-12"),
                "987654321", IDNumberType.PASSPORT, 48912223344L, "ET@space.galactic"));
        log.info("Preloaded " + personRepository.count() + " dummy persons");

        vehicleRepository.save(new Vehicle(2004, "ZS1234", LocalDate.parse("2005-07-01"),
                "SKODA", "X6", "5GAER23D89J184215", LocalDate.parse("2005-07-02"),
                4200, 320_000, FuelType.DIESEL));

        vehicleRepository.save(new Vehicle(2004, "ZS2345", LocalDate.parse("2005-07-01"),
                "HONDA", "MONDEO", "1FAHP53U22G143588", LocalDate.parse("2005-07-04"),
                2300, 160_000, FuelType.DIESEL));

        vehicleRepository.save(new Vehicle(2004, "ZS3456", LocalDate.parse("2005-07-01"),
                "FIAT", "P100D", "JTLKE50E791087958", LocalDate.parse("2005-07-05"),
                50, 300_000, FuelType.ELECTRIC));

        vehicleRepository.save(new Vehicle(2007, "ZS4567", LocalDate.parse("2008-07-01"),
                "SKODA", "V50", "1C4RJECG1FC734860", LocalDate.parse("2009-07-06"),
                4200, 320_000, FuelType.GASOLINE));

        vehicleRepository.save(new Vehicle(2003, "WN5678", LocalDate.parse("2004-07-01"),
                "HONDA", "MONDEO", "5YFBURHE5FP261348", LocalDate.parse("2004-07-09"),
                2300, 160_000, FuelType.DIESEL));

        vehicleRepository.save(new Vehicle(2001, "ZS6789", LocalDate.parse("2002-07-01"),
                "FIAT", "X6", "1FMZU73K25UA86862", LocalDate.parse("2002-08-03"),
                5000, 400_000, FuelType.HYBRID));
        log.info("Preloaded " + vehicleRepository.count() + " dummy vehicles");
        log.info("###################################### INTIVE PATRONAGE BACKEND ######################################");
    }

}