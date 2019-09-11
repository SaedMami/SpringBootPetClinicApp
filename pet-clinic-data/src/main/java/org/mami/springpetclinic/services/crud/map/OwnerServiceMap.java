package org.mami.springpetclinic.services.crud.map;

import org.mami.springpetclinic.model.Owner;
import org.mami.springpetclinic.services.crud.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapCrudService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
