package pl.aszul.patronage.services;

import pl.aszul.patronage.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class PersonServiceHashMap implements PersonService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Map<Integer, Person> persons;

    public PersonServiceHashMap() {
        persons = new HashMap<>();
    }

    @Override
    public Iterable<Person> list() {
        logger.debug("list called");
        return persons.values();
    }

    @Override
    public Person read(Integer id) {
        logger.debug("read called");
        return (persons.getOrDefault(id, null));
    }

    @Override
    public Person create(Person person) {
    logger.debug("create called");
        if (persons.containsKey(person.getId())) {
            return persons.replace(person.getId(), person);
        }
        else {
            return persons.put(person.getId(), person);
        }
    }
    @Override
    public void delete(Integer id) {
        logger.debug("delete called");
        persons.remove(id);
    }
}
