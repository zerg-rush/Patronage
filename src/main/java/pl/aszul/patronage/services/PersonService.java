package pl.aszul.patronage.services;

import pl.aszul.patronage.domain.Person;

public interface PersonService {
    Iterable<Person> listAllPersons();

    Person getPersonById(Integer id);

    Person savePerson(Person person);

    void deletePerson(Integer id);
}
