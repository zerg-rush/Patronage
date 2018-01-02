package pl.aszul.patronage1.services;

import pl.aszul.patronage1.domain.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Map<Integer, Vehicle> vehicles = new HashMap<Integer, Vehicle>();

    @Override
    public Iterable<Vehicle> listAllVehicles() {
        logger.debug("listAllVehicles called");
        return vehicles.values();
    }
    @Override
    public Vehicle getVehicleById(Integer id) {
        logger.debug("getVehicleById called");
        return (vehicles.getOrDefault(id, null));
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        logger.debug("saveVehicle called");
        if (vehicles.containsKey(vehicle.getId())) {
            return vehicles.replace(vehicle.getId(), vehicle);
        }
        else {
            return vehicles.put(vehicle.getId(), vehicle);
        }
    }

    @Override
    public void deleteVehicle(Integer id) {
        logger.debug("deleteVehicle called");
        vehicles.remove(id);
    }
}
