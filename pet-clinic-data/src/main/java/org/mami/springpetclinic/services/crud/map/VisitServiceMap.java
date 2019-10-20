package org.mami.springpetclinic.services.crud.map;

import org.mami.springpetclinic.model.Visit;
import org.mami.springpetclinic.services.crud.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceMap extends AbstractMapCrudService<Visit> implements VisitService {
    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getId() == null || visit.getPet().getOwner() == null) {
            throw new RuntimeException("Invalid Visit");
        }

        return super.save(visit);
    }
}
