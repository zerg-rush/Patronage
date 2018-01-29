package pl.aszul.patronage.repositories;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pl.aszul.patronage.domain.Person;

@Component
@Primary
@ConditionalOnProperty(name = "H2_STORAGE_ENABLED", havingValue = "false")
public class PersonRepositoryHashMapImpl implements PersonRepositoryHashMap {
    private static Map<Integer, Person> repository = new HashMap<>();

    @Override
    public Person findOne(Integer id) {
        return repository.get(id);
    }

    @Override
    public boolean exists(Integer id) {
        return repository.containsKey(id);
    }

    @Override
    public Iterable<Person> findAll() {
        return repository.values();
    }

    @Override
    public long count() {
        return repository.size();
    }

    @Override
    public void delete(Integer id) {
        repository.remove(id);
    }

    @Override
    public void deleteAll() {
        repository.clear();
    }

    @Override
    public void delete(Iterable<? extends Person> iterable) {
        for(Person it : iterable) {
            delete(it.getId());
        }
    }

    @Override
    public void delete(Person object) {
        repository.remove(object.getId());
    }

    @Override
    public Iterable<Person> findAll(Iterable<Integer> ids) {
        List<Person> list = new ArrayList<Person>();
        for(Integer id : ids) {
            Person object = findOne(id);
            if (object != null) {
                list.add(object);
            }
        }
        return list;
    }

    @Override
    public <S extends Person> Iterable<S> save(Iterable<S> objects) {
        List<S> list = new ArrayList<S>();
        for(S object : objects) {
           list.add(save(object));
        }
        return list;
    }

    @Override
    public <S extends Person> S save(S object) {
        if(repository.containsKey(object.getId())) {
            repository.replace(object.getId(), object);
        } else {
            repository.put(object.getId(), object);
        }
        return object;
    }
}
