package org.mami.springpetclinic.services;

import org.mami.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findById(long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
