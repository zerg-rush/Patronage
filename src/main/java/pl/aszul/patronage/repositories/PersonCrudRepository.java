package pl.aszul.patronage.repositories;

import org.springframework.context.annotation.Conditional;
import pl.aszul.patronage.config.StorageH2SelectedConfig;
import pl.aszul.patronage.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
//@Conditional(StorageH2SelectedConfig.class)
public interface PersonCrudRepository extends CrudRepository<Person, Integer>{
}
