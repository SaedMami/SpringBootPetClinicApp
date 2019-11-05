package org.mami.springpetclinic.services.crud.springdatajpa;

import org.mami.springpetclinic.model.Pet;
import org.mami.springpetclinic.repositories.PetRepository;
import org.mami.springpetclinic.services.crud.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
public class PetServiceSpringData implements PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetServiceSpringData(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        return StreamSupport.stream(
                this.petRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public Pet findById(Long aLong) {
        return this.petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return this.petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        this.petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        this.petRepository.deleteById(aLong);
    }
}
