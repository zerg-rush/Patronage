package pl.aszul.patronage1.services;

import pl.aszul.patronage1.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Map<Integer, Person> persons = new HashMap<Integer, Person>();

    @Override
    public Iterable<Person> listAllPersons() {
        logger.debug("listAllPersons called");
        return persons.values();
    }

    @Override
    public Person getPersonById(Integer id) {
        logger.debug("getPersonById called");
        return (persons.getOrDefault(id, null));
    }

    @Override
    public Person savePerson(Person person) {
    logger.debug("savePerson called");
        if (persons.containsKey(person.getId())) {
            return persons.replace(person.getId(), person);
        }
        else {
            return persons.put(person.getId(), person);
        }
    }
    @Override
    public void deletePerson(Integer id) {
        logger.debug("deletePerson called");
        persons.remove(id);
    }
}
