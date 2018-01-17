package pl.aszul.patronage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.aszul.patronage.domain.Person;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
