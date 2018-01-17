package pl.aszul.patronage.services;

import pl.aszul.patronage.domain.Vehicle;

public interface VehicleService {
    Iterable<Vehicle> list();

    Vehicle create(Vehicle vehicle);

    Vehicle read(Integer id);

    void delete(Integer id);
}
