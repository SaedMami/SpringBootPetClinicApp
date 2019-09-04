package org.mami.springpetclinic.services.crud.map;

import org.mami.springpetclinic.model.BaseEntity;
import org.mami.springpetclinic.services.crud.CrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapCrudService<T extends BaseEntity<ID>, ID> implements CrudService<T, ID> {
    protected Map<ID, T> map = new HashMap<>();

    @Override
    public Set<T> findAll() {
        return new HashSet(this.map.values());
    }

    @Override
    public T findById(ID id) {
        return this.map.get(id);
    }

    @Override
    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    public void deleteById(ID id) {
        this.map.remove(id);
    }

    @Override
    public T save(T object) {
        return this.map.put(object.getId(), object);
    }
}
