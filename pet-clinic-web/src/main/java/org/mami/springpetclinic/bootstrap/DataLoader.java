package org.mami.springpetclinic.bootstrap;

import org.mami.springpetclinic.model.Owner;
import org.mami.springpetclinic.model.Pet;
import org.mami.springpetclinic.model.PetType;
import org.mami.springpetclinic.model.Vet;
import org.mami.springpetclinic.services.crud.OwnerService;
import org.mami.springpetclinic.services.crud.PetTypeService;
import org.mami.springpetclinic.services.crud.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

        Owner fionnaOwner = new Owner();
        fionnaOwner.setFirstName("Fionna");
        fionnaOwner.setLastName("Gelennane");
        fionnaOwner.setAddress("123 Buckleys Road");
        fionnaOwner.setCity("Bristol");
        fionnaOwner.setTelephone("123 444 567");

        Pet fionnaPet = new Pet();
        fionnaPet.setPetType(dogType);
        fionnaPet.setOwner(fionnaOwner);
        fionnaPet.setBirthDate(LocalDate.now());
        fionnaPet.setName("Rosco");
        fionnaOwner.getPets().add(fionnaPet);

        this.ownerService.save(fionnaOwner);

        Owner mikeOwner = new Owner();
        mikeOwner.setFirstName("Michael");
        mikeOwner.setLastName("Weston");
        mikeOwner.setAddress("123 Filton Grove");
        fionnaOwner.setCity("London");
        fionnaOwner.setTelephone("457 66455 34");

        Pet mikePet = new Pet();
        mikePet.setPetType(catType);
        mikePet.setOwner(mikeOwner);
        mikePet.setBirthDate(LocalDate.now());
        mikePet.setName("Whiskers");
        mikeOwner.getPets().add(mikePet);

        this.ownerService.save(mikeOwner);

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
