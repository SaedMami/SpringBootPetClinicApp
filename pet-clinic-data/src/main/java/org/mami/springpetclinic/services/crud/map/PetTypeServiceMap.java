package org.mami.springpetclinic.services.crud.map;

import org.mami.springpetclinic.model.PetType;
import org.mami.springpetclinic.services.crud.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends AbstractMapCrudService<PetType> implements PetTypeService {
}
