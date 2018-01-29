package pl.aszul.patronage.controllers;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import pl.aszul.patronage.domain.Person;
import pl.aszul.patronage.services.PersonService;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(value = "/persons", produces = {"application/json", "application/xml"})
@Api(value = "onlinestore", description = "Controller exposing Person class objects", tags = "PersonController")
public class PersonController {

    @Autowired
    private PersonService personService;

    @ApiOperation(value = "View a list of available persons",
            response = Person.class,
            responseContainer = "Iterable")
    @ApiResponse(code = 200, message = "Successfully retrieved all persons")
    @GetMapping(value = "/list", produces = {"application/json", "application/xml"})
    public Iterable<Person> list(Model model){
        Iterable<Person> personsList = personService.list();
        return personsList;
    }

    @ApiOperation(value = "View a number of available persons", response = Map.class)
    @ApiResponse(code = 200, message = "Successfully retrieved resource")
    @GetMapping(value = "/count", produces = {"application/json", "application/xml"})
    public ResponseEntity count(Model model){
        return new ResponseEntity(Collections.singletonMap("persons", personService.count()), HttpStatus.OK);
    }

    @ApiOperation(value = "Show a person with an Id", response = Person.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Requested person not found")
    }
    )
    @GetMapping(value = "/show/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity showPerson(
            @ApiParam(value = "Id number of requested person", required = true) @PathVariable Integer id, Model model) {
        ResponseEntity<Person> response;

        Person storedPerson = personService.read(id);
        if (storedPerson != null) {
            response = new ResponseEntity(storedPerson, HttpStatus.OK);
        } else {
            response = new ResponseEntity("Requested Person not found", HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @ApiOperation(value = "Add a person")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Person added successfully"),
            @ApiResponse(code = 400, message = "Incorrect Person data"),
    }
    )
    @PostMapping(value = "/add", produces = {"application/json", "application/xml"})
    public ResponseEntity addPerson(
            @ApiParam(value = "Person that needs to be added", required = true)
            @Valid @RequestBody Person person){
        personService.create(person);
        return new ResponseEntity("Person added successfully", HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a person with an Id")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Vehicle updated successfully"),
            @ApiResponse(code = 400, message = "Incorrect Vehicle data"),
            @ApiResponse(code = 404, message = "Requested Vehicle not found")
    }
    )
    @PutMapping(value = "/update/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<?> updatePerson(
            @ApiParam(value = "Person number that needs to be updated", required = true) @PathVariable Integer id,
            @ApiParam(value = "Updated Person details", required = true) @Valid @RequestBody Person person){
        ResponseEntity<?> response;

        Person storedPerson = personService.read(id);
        if (storedPerson != null) {
            storedPerson.setSurname(person.getSurname());
            storedPerson.setName(person.getName());
            storedPerson.setGender(person.getGender());
            storedPerson.setBirthDate(person.getBirthDate());
            storedPerson.setPersonalIDNumber(person.getPersonalIDNumber());
            storedPerson.setPersonalIDNumberType(person.getPersonalIDNumberType());
            storedPerson.setTel(person.getTel());
            storedPerson.setEmail(person.getEmail());
            personService.create(storedPerson);
            response = new ResponseEntity<>("Person updated successfully", HttpStatus.ACCEPTED);
        } else {
            response = new ResponseEntity<>("Requested Person not found", HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @ApiOperation(value = "Delete a person with an Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Person deleted successfully"),
            @ApiResponse(code = 404, message = "Requested Person not found")
    }
    )
    @DeleteMapping(value = "/delete/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<?> deletePerson(@PathVariable Integer id){
        ResponseEntity<?> response;

        Person storedPerson = personService.read(id);
        if (storedPerson != null) {
            personService.delete(id);
            response = new ResponseEntity<>("Person deleted successfully", HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("Requested Person not found", HttpStatus.NOT_FOUND);
        }
        return response;
    }
}
