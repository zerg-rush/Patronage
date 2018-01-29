package pl.aszul.patronage.repositories;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.repository.CrudRepository;
import pl.aszul.patronage.domain.Vehicle;

@ConditionalOnProperty(name = "H2_STORAGE_ENABLED", havingValue = "false")
public interface VehicleRepositoryHashMap extends CrudRepository<Vehicle, Integer> {
}
