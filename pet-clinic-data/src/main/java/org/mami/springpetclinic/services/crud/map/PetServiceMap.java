package org.mami.springpetclinic.services.crud.map;

import org.mami.springpetclinic.model.Pet;
import org.mami.springpetclinic.model.Visit;
import org.mami.springpetclinic.services.crud.PetService;
import org.mami.springpetclinic.services.crud.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapCrudService<Pet> implements PetService {

    private VisitService visitService;

    @Autowired
    public PetServiceMap(VisitService visitService) {
        this.visitService = visitService;
    }

    @Override
    public Pet save(Pet pet) {
        if (pet.getVisits().size() > 0) {
            pet.getVisits().forEach(visit -> {
                if (visit.getId() == null) {
                    Visit savedVisit = this.visitService.save(visit);
                    visit.setId(savedVisit.getId());
                }
            });
        }
        return super.save(pet);
    }
}
