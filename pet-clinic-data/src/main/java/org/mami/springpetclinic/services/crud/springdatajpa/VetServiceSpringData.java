package org.mami.springpetclinic.services.crud.springdatajpa;

import org.mami.springpetclinic.model.Vet;
import org.mami.springpetclinic.repositories.VetRepository;
import org.mami.springpetclinic.services.crud.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetServiceSpringData implements VetService {

    private final VetRepository vetRepository;

    @Autowired
    public VetServiceSpringData(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        this.vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return this.vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return this.vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        this.vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        this.vetRepository.deleteById(aLong);
    }
}
