package pl.aszul.patronage1.controllers;

import pl.aszul.patronage1.domain.Person;
import pl.aszul.patronage1.services.PersonService;

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
@RequestMapping("/persons")
@Api(value = "onlinestore", description = "Controller exposing Person class objects")
public class PersonController {

    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @ApiOperation(value = "View a list of available persons",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved resource"),
            @ApiResponse(code = 201, message = "Successfully created resource"),
            @ApiResponse(code = 401, message = "Athorization failed"),
            @ApiResponse(code = 403, message = "Access to the resource is forbidden"),
            @ApiResponse(code = 404, message = "The resource is not found")
    }
    )
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Person> list(Model model){
        Iterable<Person> personsList = personService.listAllPersons();
        return personsList;
    }
    @ApiOperation(value = "Show a person with an Id",response = Person.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity showPerson(@PathVariable Integer id, Model model){
        ResponseEntity<Person> response = null;

        Person storedPerson = personService.getPersonById(id);
        if (storedPerson != null) {
            response = new ResponseEntity(storedPerson, HttpStatus.OK);
        } else {
            response = new ResponseEntity("Person not found", HttpStatus.NOT_FOUND);
        }
        return response;
    }
    @ApiOperation(value = "Add a person")
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity saveProduct(@RequestBody Person person){
        personService.savePerson(person);
        return new ResponseEntity("Person successfully created", HttpStatus.CREATED);
    }
    @ApiOperation(value = "Update a person")
    @RequestMapping(value = "/update/{id}", method= RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updatePerson(@PathVariable Integer id, @RequestBody Person person){
        ResponseEntity<?> response = null;

        Person storedPerson = personService.getPersonById(id);
        if (storedPerson != null) {
            storedPerson.setSurname(person.getSurname());
            storedPerson.setName(person.getName());
            storedPerson.setSex(person.getSex());
            storedPerson.setBirthDate(person.getBirthDate());
            storedPerson.setPersonalIDNumber(person.getPersonalIDNumber());
            storedPerson.setPersonalIDNumberType(person.getPersonalIDNumberType());
            storedPerson.setTel(person.getTel());
            storedPerson.setEmail(person.getEmail());
            personService.savePerson(storedPerson);
            response = new ResponseEntity<>("Person updated successfully", HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
        }
        return response;
    }
    @ApiOperation(value = "Delete a person")
    @RequestMapping(value = "/delete/{id}", method= RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> deletePerson(@PathVariable Integer id){
        ResponseEntity<?> response = null;

        Person storedPerson = personService.getPersonById(id);
        if (storedPerson != null) {
            personService.deletePerson(id);
            response = new ResponseEntity<>("Person deleted successfully", HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
        }
        return response;
    }
}
