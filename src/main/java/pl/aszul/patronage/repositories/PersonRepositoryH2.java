package pl.aszul.patronage.repositories;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.aszul.patronage.domain.Person;

@RepositoryRestResource
@ConditionalOnProperty(name = "H2_STORAGE_ENABLED", havingValue = "true", matchIfMissing = true)
public interface PersonRepositoryH2 extends CrudRepository<Person, Integer> {
}
