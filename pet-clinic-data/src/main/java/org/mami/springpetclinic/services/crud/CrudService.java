package org.mami.springpetclinic.services.crud;

import org.mami.springpetclinic.model.BaseEntity;

import java.util.Set;

public interface CrudService<T extends BaseEntity<ID>, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save (T object);

    void delete(T object);

    void deleteById(ID id);
}
