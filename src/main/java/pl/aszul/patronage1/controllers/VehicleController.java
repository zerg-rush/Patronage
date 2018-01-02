package pl.aszul.patronage1.controllers;

import pl.aszul.patronage1.domain.Vehicle;
import pl.aszul.patronage1.services.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
@Api(value="onlinestore", description="Controller exposing Vehicle class objects")
public class VehicleController {

    private VehicleService vehicleService;

    @Autowired
    public void setVehicleService(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @ApiOperation(value = "View a list of available vehicles",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved resource"),
            @ApiResponse(code = 201, message = "Successfully created resource"),
            @ApiResponse(code = 401, message = "Athorization failed"),
            @ApiResponse(code = 403, message = "Access to the resource is forbidden"),
            @ApiResponse(code = 404, message = "The resource is not found")
    }
    )
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Vehicle> list(Model model){
        Iterable<Vehicle> vehicleList = vehicleService.listAllVehicles();
        return vehicleList;
    }
    @ApiOperation(value = "Show a vehicle with a VIN number",response = Vehicle.class)
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity showVehicle(@PathVariable Integer id, Model model){
        ResponseEntity<Vehicle> response = null;

        Vehicle storedVehicle = vehicleService.getVehicleById(id);
        if (storedVehicle != null) {
            response = new ResponseEntity(storedVehicle, HttpStatus.OK);
        } else {
            response = new ResponseEntity("Vehicle not found", HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @ApiOperation(value = "Add a vehicle")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveVehicle(@RequestBody Vehicle vehicle){
        vehicleService.saveVehicle(vehicle);
        return new ResponseEntity("Vehicle saved successfully", HttpStatus.OK);
    }
    @ApiOperation(value = "Update a vehicle")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> updateVehicle(@PathVariable Integer id, @RequestBody Vehicle vehicle){
        ResponseEntity<?> response = null;

        Vehicle storedVehicle = vehicleService.getVehicleById(id);
        if (storedVehicle != null) {
            storedVehicle.setVehicleType(vehicle.getVehicleType());
            storedVehicle.setVehiclePurpose(vehicle.getVehiclePurpose());
            storedVehicle.setManufacturingYear(vehicle.getManufacturingYear());
            storedVehicle.setMaxLoadCapacity(vehicle.getMaxLoadCapacity());
            storedVehicle.setMaxAxlePressure(vehicle.getMaxAxlePressure());
            storedVehicle.setVehicleCardNumber(vehicle.getVehicleCardNumber());
            storedVehicle.setRegistrationCardSeries(vehicle.getRegistrationCardSeries());
            storedVehicle.setRegistrationCardIssuedBy(vehicle.getRegistrationCardIssuedBy());
            storedVehicle.setPlateNumber(vehicle.getPlateNumber());
            storedVehicle.setFirstRegistrationDate(vehicle.getFirstRegistrationDate());
            storedVehicle.setRegistrationCardOwnerName(vehicle.getRegistrationCardOwnerName());
            storedVehicle.setRegistrationCardOwnerIDNumber(vehicle.getRegistrationCardOwnerIDNumber());
            storedVehicle.setRegistrationCardOwnerAddress(vehicle.getRegistrationCardOwnerAddress());
            storedVehicle.setVehicleOwnerName(vehicle.getVehicleOwnerName());
            storedVehicle.setVehicleOwnerIDNumber(vehicle.getVehicleOwnerIDNumber());
            storedVehicle.setVehicleOwnerAddress(vehicle.getVehicleOwnerAddress());
            storedVehicle.setBrandName(vehicle.getBrandName());
            storedVehicle.setModelName(vehicle.getModelName());
            storedVehicle.setShortModelName(vehicle.getShortModelName());
            storedVehicle.setVINNumber(vehicle.getVINNumber());
            storedVehicle.setMaxWeight(vehicle.getMaxWeight());
            storedVehicle.setAcceptableWeight(vehicle.getAcceptableWeight());
            storedVehicle.setAcceptableGroupWeight(vehicle.getAcceptableGroupWeight());
            storedVehicle.setWeight(vehicle.getWeight());
            storedVehicle.setRegistrationCardExpiryDate(vehicle.getRegistrationCardExpiryDate());
            storedVehicle.setRegistrationCardIssueDate(vehicle.getRegistrationCardIssueDate());
            storedVehicle.setVehicleCategory(vehicle.getVehicleCategory());
            storedVehicle.setHomologationNumber(vehicle.getHomologationNumber());
            storedVehicle.setAxleNumber(vehicle.getAxleNumber());
            storedVehicle.setMaxWeightWTrailerWBreaks(vehicle.getMaxWeightWTrailerWBreaks());
            storedVehicle.setMaxWeightWTrailerWOBreaks(vehicle.getMaxWeightWTrailerWOBreaks());
            storedVehicle.setEngineCapacity(vehicle.getEngineCapacity());
            storedVehicle.setEnginePower(vehicle.getEnginePower());
            storedVehicle.setFuelType(vehicle.getFuelType());
            storedVehicle.setPowerToWeightRatio(vehicle.getPowerToWeightRatio());
            storedVehicle.setSeats(vehicle.getSeats());
            storedVehicle.setStandingPlaces(vehicle.getStandingPlaces());
            vehicleService.saveVehicle(storedVehicle);
            response = new ResponseEntity<>("Vehicle updated successfully", HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("Vehicle not found", HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @ApiOperation(value = "Delete a vehicle")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<?> deleteVehicle(@PathVariable Integer id){
        ResponseEntity<?> response = null;

        Vehicle storedVehicle = vehicleService.getVehicleById(id);
        if (storedVehicle != null) {
            vehicleService.deleteVehicle(id);
            response = new ResponseEntity<>("Vehicle deleted successfully", HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("Vehicle not found", HttpStatus.NOT_FOUND);
        }
        return response;
    }

}
