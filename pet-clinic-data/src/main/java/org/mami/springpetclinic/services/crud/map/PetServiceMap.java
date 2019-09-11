package org.mami.springpetclinic.services.crud.map;

import org.mami.springpetclinic.model.Pet;
import org.mami.springpetclinic.services.crud.PetService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PetServiceMap extends AbstractMapCrudService<Pet, Long> implements PetService {
    @Override
    protected Long getNextId() {
        return this.map.isEmpty() ? 1L : Collections.max(this.map.keySet()) + 1L;
    }
}
