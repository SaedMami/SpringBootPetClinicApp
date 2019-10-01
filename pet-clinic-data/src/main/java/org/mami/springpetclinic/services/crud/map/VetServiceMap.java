package org.mami.springpetclinic.services.crud.map;

import org.mami.springpetclinic.model.Specialty;
import org.mami.springpetclinic.model.Vet;
import org.mami.springpetclinic.services.crud.SpecialtyService;
import org.mami.springpetclinic.services.crud.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapCrudService<Vet> implements VetService {
    private SpecialtyService specialtyService;

    @Autowired
    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet save(Vet vet) {
        if (vet.getSpecialties().size() > 0) {
            vet.getSpecialties().forEach(specialty -> {
                if (specialty.getId() == null) {
                    Specialty savedSpecialty = this.specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(vet);
    }
}
