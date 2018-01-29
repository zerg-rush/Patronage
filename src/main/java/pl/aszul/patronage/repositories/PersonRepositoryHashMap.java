package pl.aszul.patronage.repositories;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.repository.CrudRepository;
import pl.aszul.patronage.domain.Person;

@ConditionalOnProperty(name = "H2_STORAGE_ENABLED", havingValue = "false")
public interface PersonRepositoryHashMap extends CrudRepository<Person, Integer> {
}
