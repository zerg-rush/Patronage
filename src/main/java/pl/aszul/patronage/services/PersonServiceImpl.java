package pl.aszul.patronage.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.aszul.patronage.domain.Person;

@Service
public class PersonServiceImpl implements PersonService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CrudRepository<Person, Integer> personRepository;

    @Override
    public Iterable<Person> list() {
        logger.debug("list called");
        return personRepository.findAll();
    }

    @Override
    public Long count() {
        logger.debug("count called");
        return personRepository.count();
    }

    @Override
    public Person create(Person person) {
        logger.debug("create called");
        return personRepository.save(person);
    }

    @Override
    public Person read(Integer id) {
        logger.debug("read called " + id);
        return personRepository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        logger.debug("delete called");
        personRepository.delete(id);
    }
}

