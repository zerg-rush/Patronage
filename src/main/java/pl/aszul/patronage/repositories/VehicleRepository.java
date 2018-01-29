package pl.aszul.patronage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.aszul.patronage.domain.Vehicle;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
