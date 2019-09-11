package org.mami.springpetclinic.services.crud.map;

import org.mami.springpetclinic.model.Vet;
import org.mami.springpetclinic.services.crud.VetService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class VetServiceMap extends AbstractMapCrudService<Vet, Long> implements VetService {
    @Override
    protected Long getNextId() {
        return this.map.isEmpty() ? 1L : Collections.max(this.map.keySet()) + 1L;
    }
}
