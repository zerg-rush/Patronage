package pl.aszul.patronage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.aszul.patronage.domain.Vehicle;
import pl.aszul.patronage.repositories.VehicleRepository;

@Service
public class VehicleServiceH2 implements VehicleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private VehicleRepository repository;

    @Autowired
    public VehicleServiceH2(VehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Vehicle> list() {
        logger.debug("listAllVehicle called");
        return repository.findAll();
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        logger.debug("create called");
        return repository.save(vehicle);
    }

    @Override
    public Vehicle read(Integer id) {
        logger.debug("read called");
        return repository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        logger.debug("delete called");
        repository.delete(id);
    }
}
