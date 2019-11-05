package org.mami.springpetclinic.services.crud.map;

import org.mami.springpetclinic.model.PetType;
import org.mami.springpetclinic.services.crud.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeServiceMap extends AbstractMapCrudService<PetType> implements PetTypeService {
}
