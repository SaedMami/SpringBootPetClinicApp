package org.mami.springpetclinic.services;

import org.mami.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(long id);

    Vet save(Vet owner);

    Set<Vet> findAll();
}
