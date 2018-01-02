package pl.aszul.patronage1.services;

import pl.aszul.patronage1.domain.Vehicle;

public interface VehicleService {
    Iterable<Vehicle> listAllVehicles();

    Vehicle getVehicleById(Integer id);

    Vehicle saveVehicle(Vehicle vehicle);

    void deleteVehicle(Integer id);
}
