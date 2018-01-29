package pl.aszul.patronage.repositories;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pl.aszul.patronage.domain.Vehicle;

@Component
@Primary
@ConditionalOnProperty(name = "H2_STORAGE_ENABLED", havingValue = "false")
public class VehicleRepositoryHashMapImpl implements VehicleRepositoryHashMap {
    private static Map<Integer, Vehicle> repository = new HashMap<>();

    @Override
    public Vehicle findOne(Integer id) {
        return repository.get(id);
    }

    @Override
    public boolean exists(Integer id) {
        return repository.containsKey(id);
    }

    @Override
    public Iterable<Vehicle> findAll() {
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
    public void delete(Iterable<? extends Vehicle> iterable) {
        for(Vehicle it : iterable) {
            delete(it.getId());
        }
   }

    @Override
    public void delete(Vehicle object) {
        repository.remove(object.getId());
    }

    @Override
    public Iterable<Vehicle> findAll(Iterable<Integer> ids) {
        List<Vehicle> list = new ArrayList<Vehicle>();
        for(Integer id : ids) {
            Vehicle object = findOne(id);
            if (object != null) {
                list.add(object);
            }
        }
        return list;
    }

    @Override
    public <S extends Vehicle> Iterable<S> save(Iterable<S> objects) {
        List<S> list = new ArrayList<S>();
        for(S object : objects) {
           list.add(save(object));
        }
        return list;
    }

    @Override
    public <S extends Vehicle> S save(S object) {
        if(repository.containsKey(object.getId())) {
            repository.replace(object.getId(), object);
        } else {
            repository.put(object.getId(), object);
        }
        return object;
    }

}