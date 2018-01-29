package pl.aszul.patronage.config;

import pl.aszul.patronage.repositories.PersonRepository;
import pl.aszul.patronage.repositories.VehicleRepository;
import pl.aszul.patronage.services.PersonService;
import pl.aszul.patronage.services.PersonServiceH2;
import pl.aszul.patronage.services.PersonServiceHashMap;
import pl.aszul.patronage.services.VehicleService;
import pl.aszul.patronage.services.VehicleServiceH2;
import pl.aszul.patronage.services.VehicleServiceHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class StorageConfig {
    private final PersonRepository personRepository;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public StorageConfig(PersonRepository personRepository, VehicleRepository vehicleRepository) {
        this.personRepository = personRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Bean
    @Primary
    @ConditionalOnProperty(name = "H2_STORAGE_ENABLED", havingValue = "true", matchIfMissing = true)
    public VehicleService vehicleServiceH2() {
        return new VehicleServiceH2(vehicleRepository);
    }

    @Bean
    @Primary
    @ConditionalOnProperty(name = "H2_STORAGE_ENABLED", havingValue = "true", matchIfMissing = true)
    public PersonService personServiceH2() {
        return new PersonServiceH2(personRepository);
    }

    @Bean
    @Primary
    @ConditionalOnProperty(name = "H2_STORAGE_ENABLED", havingValue = "false")
    public VehicleService vehicleServiceHashMap() {
        return new VehicleServiceHashMap();
    }

    @Bean
    @Primary
    @ConditionalOnProperty(name = "H2_STORAGE_ENABLED", havingValue = "false")
    public PersonService personServiceHashMap() {
        return new PersonServiceHashMap();
    }
}
