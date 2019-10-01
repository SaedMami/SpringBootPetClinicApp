package org.mami.springpetclinic.services.crud.map;

import org.mami.springpetclinic.model.BaseEntity;
import org.mami.springpetclinic.services.crud.CrudService;

import java.util.*;

public abstract class AbstractMapCrudService<T extends BaseEntity<Long>> implements CrudService<T, Long> {

    protected Map<Long, T> map = new HashMap<>();

    @Override
    public Set<T> findAll() {
        return new HashSet(this.map.values());
    }

    @Override
    public T findById(Long id) {
        return this.map.get(id);
    }

    @Override
    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    public void deleteById(Long id) {
        this.map.remove(id);
    }

    @Override
    public T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(this.getNextId());
            }
            this.map.put(object.getId(), object);
            return object;
        }

        throw new RuntimeException("Cannot save null object");
    }

    private Long getNextId() {
        return this.map.isEmpty() ? 1L : Collections.max(this.map.keySet()) + 1L;
    }
}
