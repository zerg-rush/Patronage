package pl.aszul.patronage.services;

import pl.aszul.patronage.domain.Person;
import pl.aszul.patronage.repositories.PersonRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceH2 implements PersonService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private PersonRepository repository;

    @Autowired
    public PersonServiceH2(PersonRepository personRepository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Person> list() {
        logger.debug("list called");
        return repository.findAll();
    }

    @Override
    public Person create(Person person) {
        logger.debug("create called");
        return repository.save(person);
    }

    @Override
    public Person read(Integer id) {
        logger.debug("read called");
        return repository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        logger.debug("delete called");
        repository.delete(id);
    }
}

