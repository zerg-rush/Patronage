package pl.aszul.patronage.services;

import pl.aszul.patronage.domain.Vehicle;

public interface VehicleService {
    Iterable<Vehicle> listAllVehicles();

    Vehicle getVehicleById(Integer id);

    Vehicle saveVehicle(Vehicle vehicle);

    void deleteVehicle(Integer id);
}
