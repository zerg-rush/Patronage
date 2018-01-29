package pl.aszul.patronage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.aszul.patronage.domain.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CrudRepository<Vehicle, Integer> vehicleRepository;

    @Override
    public Iterable<Vehicle> list() {
        logger.debug("listAllVehicle called");
        return vehicleRepository.findAll();
    }

    @Override
    public Long count() {
        logger.debug("count called");
        return vehicleRepository.count();
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        logger.debug("create called");
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle read(Integer id) {
        logger.debug("read called");
        return vehicleRepository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        logger.debug("delete called");
        vehicleRepository.delete(id);
    }
}
