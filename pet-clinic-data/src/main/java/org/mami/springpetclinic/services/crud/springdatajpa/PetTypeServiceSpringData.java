package org.mami.springpetclinic.services.crud.springdatajpa;

import org.mami.springpetclinic.model.PetType;
import org.mami.springpetclinic.repositories.PetTypeRepository;
import org.mami.springpetclinic.services.crud.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Profile("springdatajpa")
public class PetTypeServiceSpringData implements PetTypeService {

    @Autowired
    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceSpringData(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public Set<PetType> findAll() {
        return StreamSupport.stream(
                this.petTypeRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public PetType findById(Long aLong) {
        return this.petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return this.petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        this.petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        this.petTypeRepository.deleteById(aLong);
    }
}
