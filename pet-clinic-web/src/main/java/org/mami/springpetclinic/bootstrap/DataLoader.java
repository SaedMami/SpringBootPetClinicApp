package org.mami.springpetclinic.bootstrap;

import org.mami.springpetclinic.model.Owner;
import org.mami.springpetclinic.model.PetType;
import org.mami.springpetclinic.model.Vet;
import org.mami.springpetclinic.services.crud.OwnerService;
import org.mami.springpetclinic.services.crud.PetTypeService;
import org.mami.springpetclinic.services.crud.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) {

        PetType dogType = new PetType();
        dogType.setName("Dog");
        this.petTypeService.save(dogType);

        PetType catType = new PetType();
        catType.setName("Cat");
        this.petTypeService.save(catType);

        Owner owner1 = new Owner();
        owner1.setFirstName("Fionna");
        owner1.setLastName("Gelennane");

        this.ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Michael");
        owner2.setLastName("Weston");

        this.ownerService.save(owner2);

        System.out.println("loaded Owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        this.vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ace");
        vet2.setLastName("Ventura");

        this.vetService.save(vet2);

        System.out.println("loaded Vets ...");
    }
}
