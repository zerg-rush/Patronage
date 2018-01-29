package pl.aszul.patronage.controllers;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import pl.aszul.patronage.domain.Vehicle;
import pl.aszul.patronage.services.VehicleService;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(value = "/vehicles", produces = {"application/json", "application/xml"})
@Api(value = "onlinestore", description = "Controller exposing Vehicle class objects", tags = "VehicleController")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @ApiOperation(value = "View a list of available vehicles",
            response = Vehicle.class,
            responseContainer = "Iterable")
    @ApiResponse(code = 200, message = "Successfully retrieved all vehicles")
    @GetMapping(value = "/list", produces = {"application/json", "application/xml"})
    public Iterable<Vehicle> list(Model model) {
        Iterable<Vehicle> vehicleList = vehicleService.list();
        return vehicleList;
    }

    @ApiOperation(value = "View a number of available vehicles", response = Map.class)
    @ApiResponse(code = 200, message = "Successfully retrieved resource")
    @GetMapping(value = "/count", produces = {"application/json", "application/xml"})
    public ResponseEntity count(Model model){
        return new ResponseEntity(Collections.singletonMap("vehicles", vehicleService.count()), HttpStatus.OK);
    }

    @ApiOperation(value = "Show a vehicle with an Id", response = Vehicle.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Requested vehicle not found")
    }
    )
    @GetMapping(value = "/show/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity showVehicle(
            @ApiParam(value = "Id number of requested vehicle", required = true) @PathVariable Integer id, Model model) {
        ResponseEntity<Vehicle> response;

        Vehicle storedVehicle = vehicleService.read(id);
        if (storedVehicle != null) {
            response = new ResponseEntity(storedVehicle, HttpStatus.OK);
        } else {
            response = new ResponseEntity("Requested Vehicle not found", HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @ApiOperation(value = "Add a vehicle")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Vehicle added successfully"),
            @ApiResponse(code = 400, message = "Incorrect Vehicle data"),
    }
    )
    @PostMapping(value = "/add", produces = {"application/json", "application/xml"})
    public ResponseEntity addVehicle(
            @ApiParam(value = "Vehicle that needs to be added", required = true)
            @Valid @RequestBody Vehicle vehicle) {
        vehicleService.create(vehicle);
        return new ResponseEntity("Vehicle added successfully", HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a vehicle with an Id")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Vehicle updated successfully"),
            @ApiResponse(code = 400, message = "Incorrect Vehicle data"),
            @ApiResponse(code = 404, message = "Requested Vehicle not found")
    }
    )
    @PutMapping(value = "/update/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<?> updateVehicle(
            @ApiParam(value = "Vehicle number that needs to be updated", required = true) @PathVariable Integer id,
            @ApiParam(value = "Updated Vehicle details", required = true) @Valid @RequestBody Vehicle vehicle) {
        ResponseEntity<?> response;

        Vehicle storedVehicle = vehicleService.read(id);
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
            vehicleService.create(storedVehicle);
            response = new ResponseEntity<>("Vehicle updated successfully", HttpStatus.ACCEPTED);
        } else {
            response = new ResponseEntity<>("Requested Vehicle not found", HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @ApiOperation(value = "Delete a vehicle with an Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Vehicle deleted successfully"),
            @ApiResponse(code = 404, message = "Requested Vehicle not found")
    }
    )
    @DeleteMapping(value = "/delete/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<?> deleteVehicle(@PathVariable Integer id) {
        ResponseEntity<?> response;

        Vehicle storedVehicle = vehicleService.read(id);
        if (storedVehicle != null) {
            vehicleService.delete(id);
            response = new ResponseEntity<>("Vehicle deleted successfully", HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("Requested Vehicle not found", HttpStatus.NOT_FOUND);
        }
        return response;
    }
}