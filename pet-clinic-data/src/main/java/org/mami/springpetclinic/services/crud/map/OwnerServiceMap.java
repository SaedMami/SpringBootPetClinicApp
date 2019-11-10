package org.mami.springpetclinic.services.crud.map;

import org.mami.springpetclinic.model.Owner;
import org.mami.springpetclinic.model.Pet;
import org.mami.springpetclinic.model.PetType;
import org.mami.springpetclinic.services.crud.OwnerService;
import org.mami.springpetclinic.services.crud.PetService;
import org.mami.springpetclinic.services.crud.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapCrudService<Owner> implements OwnerService {

    private PetTypeService petTypeService;
    private PetService petService;

    @Autowired
    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner save(Owner object) {

        // see if we need to save the pets
        if (object.getPets() != null) {
            object.getPets().forEach(pet -> {

                // see if we need to save the pet type
                if (pet.getPetType() == null) {
                    throw new RuntimeException("A Pet can't have a null PetType");
                }

                if (pet.getPetType().getId() == null) {
                    PetType savedPetType = this.petTypeService.save(pet.getPetType());
                    pet.getPetType().setId(savedPetType.getId());
                }

                // see if we need to save the pet
                if (pet.getId() == null) {
                    Pet savedPet = this.petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
