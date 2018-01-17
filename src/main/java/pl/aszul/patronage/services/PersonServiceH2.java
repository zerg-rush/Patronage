package pl.aszul.patronage.services;

import org.springframework.context.annotation.Conditional;
import pl.aszul.patronage.config.StorageH2SelectedConfig;
import pl.aszul.patronage.domain.Person;
import pl.aszul.patronage.repositories.PersonCrudRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Qualifier("H2Bean")
@Conditional(StorageH2SelectedConfig.class)
public class PersonServiceH2 implements PersonService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private PersonCrudRepository personCrudRepository;

    // to be used for conditional annotation for HashMap mode
    @Autowired
 //   @Qualifier("H2Bean")
    @Conditional(StorageH2SelectedConfig.class)
    public void setPersonCrudRepository(PersonCrudRepository personCrudRepository) {
        this.personCrudRepository = personCrudRepository;
    }

    @Override
    public Iterable<Person> listAllPersons() {
        logger.debug("listAllPersons called");
        return personCrudRepository.findAll();
    }

    @Override
    public Person getPersonById(Integer id) {
        logger.debug("getPersonById called");
        return personCrudRepository.findOne(id);
    }

    @Override
    public Person savePerson(Person person) {
        logger.debug("savePerson called");
        return personCrudRepository.save(person);
    }

    @Override
    public void deletePerson(Integer id) {
        logger.debug("deletePerson called");
        personCrudRepository.delete(id);
    }
}

