package org.mami.springpetclinic.bootstrap;

import org.mami.springpetclinic.model.*;
import org.mami.springpetclinic.services.crud.OwnerService;
import org.mami.springpetclinic.services.crud.PetTypeService;
import org.mami.springpetclinic.services.crud.SpecialtyService;
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
    private final SpecialtyService specialtyService;


    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) {

        LoadOwners();

        loadVets();
    }

    private void loadVets() {
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = this.specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = this.specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = this.specialtyService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);
        this.vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ace");
        vet2.setLastName("Ventura");
        vet2.getSpecialties().add(savedSurgery);
        vet2.getSpecialties().add(savedDentistry);
        this.vetService.save(vet2);

        System.out.println("loaded Vets ...");
    }

    private void LoadOwners() {
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
    }
}
