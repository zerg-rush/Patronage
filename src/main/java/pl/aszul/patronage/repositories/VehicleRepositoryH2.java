package pl.aszul.patronage.repositories;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.aszul.patronage.domain.Vehicle;

@RepositoryRestResource
@ConditionalOnProperty(name = "H2_STORAGE_ENABLED", havingValue = "true", matchIfMissing = true)
public interface VehicleRepositoryH2 extends CrudRepository<Vehicle, Integer> {
}
