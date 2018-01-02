package pl.aszul.patronage1.services;

import pl.aszul.patronage1.domain.Person;

public interface PersonService {
    Iterable<Person> listAllPersons();

    Person getPersonById(Integer id);

    Person savePerson(Person person);

    void deletePerson(Integer id);
}
