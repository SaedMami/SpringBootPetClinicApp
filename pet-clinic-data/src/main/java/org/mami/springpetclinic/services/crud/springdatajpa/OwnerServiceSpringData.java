package org.mami.springpetclinic.services.crud.springdatajpa;

import org.mami.springpetclinic.model.Owner;
import org.mami.springpetclinic.repositories.OwnerRepository;
import org.mami.springpetclinic.services.crud.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

;

@Service
@Profile("springdatajpa")
public class OwnerServiceSpringData implements OwnerService {

    @Autowired
    private final OwnerRepository ownerRepository;

    public OwnerServiceSpringData(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findAll() {
        return StreamSupport.stream(
                this.ownerRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public Owner findById(Long aLong) {
        return this.ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return this.ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        this.ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        this.ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.ownerRepository.findByLastName(lastName);
    }
}
