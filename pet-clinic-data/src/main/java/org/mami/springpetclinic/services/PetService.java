package org.mami.springpetclinic.services;

import org.mami.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(long id);

    Pet save(Pet owner);

    Set<Pet> findAll();
}
