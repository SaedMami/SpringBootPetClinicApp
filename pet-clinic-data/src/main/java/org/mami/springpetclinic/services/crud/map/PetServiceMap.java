package org.mami.springpetclinic.services.crud.map;

import org.mami.springpetclinic.model.Pet;
import org.mami.springpetclinic.services.crud.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapCrudService<Pet> implements PetService {
}
