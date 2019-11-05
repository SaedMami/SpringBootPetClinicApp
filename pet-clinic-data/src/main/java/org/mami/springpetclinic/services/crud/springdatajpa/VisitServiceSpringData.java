package org.mami.springpetclinic.services.crud.springdatajpa;

import org.mami.springpetclinic.model.Visit;
import org.mami.springpetclinic.repositories.VisitRepository;
import org.mami.springpetclinic.services.crud.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitServiceSpringData implements VisitService {

    private final VisitRepository visitRepository;

    @Autowired
    public VisitServiceSpringData(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        this.visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return this.visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return this.visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        this.visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        this.visitRepository.deleteById(aLong);
    }
}
