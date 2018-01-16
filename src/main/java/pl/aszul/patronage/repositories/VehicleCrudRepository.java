package pl.aszul.patronage.repositories;

import org.springframework.context.annotation.Conditional;
import pl.aszul.patronage.config.StorageH2SelectedConfig;
import pl.aszul.patronage.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
@Conditional(StorageH2SelectedConfig.class)
public interface VehicleCrudRepository extends CrudRepository<Vehicle, Integer>{
}
