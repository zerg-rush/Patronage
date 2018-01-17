package pl.aszul.patronage.services;

import org.springframework.context.annotation.Conditional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.aszul.patronage.config.StorageH2SelectedConfig;
import pl.aszul.patronage.domain.Vehicle;
import pl.aszul.patronage.repositories.VehicleCrudRepository;

@Service
// @Qualifier("H2Bean")
@Conditional(StorageH2SelectedConfig.class)
public class VehicleServiceH2 implements VehicleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private VehicleCrudRepository vehicleCrudRepository;

    @Autowired
//    @Conditional(StorageH2SelectedConfig.class)
    public void setVehicleCrudRepository(VehicleCrudRepository vehicleCrudRepository) {
        this.vehicleCrudRepository = vehicleCrudRepository;
    }

    @Override
    public Iterable<Vehicle> listAllVehicles() {
        logger.debug("listAllVehicle called");
        return vehicleCrudRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Integer id) {
        logger.debug("getVehicleById called");
        return vehicleCrudRepository.findOne(id);
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        logger.debug("saveVehicle called");
        return vehicleCrudRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(Integer id) {
        logger.debug("deleteVehicle called");
        vehicleCrudRepository.delete(id);
    }
}
