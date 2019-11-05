package org.mami.springpetclinic.bootstrap;

import org.mami.springpetclinic.model.*;
import org.mami.springpetclinic.services.crud.*;
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
    private final VisitService visitService;

    private final PetType catType;
    private final PetType dogType;


    @Autowired
    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialtyService specialtyService,
                      VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;

        this.catType = new PetType();
        this.catType.setName("Cat");

        this.dogType = new PetType();
        this.dogType.setName("Dog");

        this.petTypeService.save(catType);
        this.petTypeService.save(dogType);
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
        Owner owner1 = new Owner();
        owner1.setFirstName("Fionna");
        owner1.setLastName("Gelennane");
        owner1.setAddress("123 Buckleys Road");
        owner1.setCity("Bristol");
        owner1.setTelephone("123 444 567");

        Pet owner1Pet = new Pet();
        owner1Pet.setPetType(dogType);
        owner1Pet.setOwner(owner1);
        owner1Pet.setBirthDate(LocalDate.now());
        owner1Pet.setName("Rosco");
        owner1.getPets().add(owner1Pet);

        Visit owner1PetVisit = new Visit();
        owner1PetVisit.setPet(owner1Pet);
        owner1PetVisit.setDate(LocalDate.now());
        owner1PetVisit.setDescription("Sneezy Doggo");
        this.ownerService.save(owner1);
        this.visitService.save(owner1PetVisit);

        Owner owner2 = new Owner();
        owner2.setFirstName("Michael");
        owner2.setLastName("Weston");
        owner2.setAddress("123 Filton Grove");
        owner1.setCity("London");
        owner1.setTelephone("457 66455 34");

        Pet owner2Pet = new Pet();
        owner2Pet.setPetType(catType);
        owner2Pet.setOwner(owner2);
        owner2Pet.setBirthDate(LocalDate.now());
        owner2Pet.setName("Whiskers");
        owner2.getPets().add(owner2Pet);

        this.ownerService.save(owner2);

        System.out.println("loaded Owners ...");
    }
}
