package pl.aszul.patronage.services;

import pl.aszul.patronage.domain.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class VehicleServiceHashMap implements VehicleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Map<Integer, Vehicle> vehicles;

    public VehicleServiceHashMap() {
        vehicles = new HashMap<>();
    }

    @Override
    public Iterable<Vehicle> list() {
        logger.debug("list called");
        return vehicles.values();
    }
    @Override
    public Vehicle read(Integer id) {
        logger.debug("read called");
        return (vehicles.getOrDefault(id, null));
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        logger.debug("create called");
        if (vehicles.containsKey(vehicle.getId())) {
            return vehicles.replace(vehicle.getId(), vehicle);
        }
        else {
            return vehicles.put(vehicle.getId(), vehicle);
        }
    }

    @Override
    public void delete(Integer id) {
        logger.debug("delete called");
        vehicles.remove(id);
    }
}
