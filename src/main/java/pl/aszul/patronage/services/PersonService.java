package pl.aszul.patronage.services;

import pl.aszul.patronage.domain.Person;

public interface PersonService {
    Iterable<Person> list();

    Person create(Person person);

    Person read(Integer id);

    void delete(Integer id);
}
