package org.mami.springpetclinic.repositories;

import org.mami.springpetclinic.model.BaseEntity;
import org.mami.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository<V extends BaseEntity<Long>, L extends Number> extends CrudRepository<Vet, Long> {
}
