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

        this.catType = PetType.builder().name("Cat").build();

        this.dogType = PetType.builder().name("Dog").build();

        this.petTypeService.save(catType);
        this.petTypeService.save(dogType);
    }

    @Override
    public void run(String... args) {

        LoadOwners();

        loadVets();
    }

    private void loadVets() {
        Specialty radiology = Specialty.builder().description("Radiology").build();
        Specialty savedRadiology = this.specialtyService.save(radiology);

        Specialty surgery = Specialty.builder().description("Surgery").build();
        Specialty savedSurgery = this.specialtyService.save(surgery);

        Specialty dentistry = Specialty.builder().description("Dentistry").build();
        Specialty savedDentistry = this.specialtyService.save(dentistry);

        Vet vet1 = Vet.builder().firstName("Sam").lastName("Axe").build();
        vet1.getSpecialties().add(savedRadiology);
        this.vetService.save(vet1);

        Vet vet2 = Vet.builder().firstName("Ace").lastName("Ventura").build();
        vet2.getSpecialties().add(savedSurgery);
        vet2.getSpecialties().add(savedDentistry);
        this.vetService.save(vet2);

        System.out.println("loaded Vets ...");
    }

    private void LoadOwners() {
        Owner owner1 = Owner.builder()
                .firstName("Fionna")
                .lastName("Gelennane")
                .address("123 Buckleys Road")
                .city("Bristol")
                .telephone("123 444 567").build();

        Pet owner1Pet = Pet.builder()
                .petType(dogType)
                .name("Rosco")
                .birthDate(LocalDate.now())
                .build();

        owner1Pet.setOwner(owner1);
        owner1.getPets().add(owner1Pet);

        Visit owner1PetVisit = Visit.builder()
                .pet(owner1Pet)
                .date(LocalDate.now())
                .description("Sneezy Doggo")
                .build();

        this.ownerService.save(owner1);
        this.visitService.save(owner1PetVisit);

        Owner owner2 = Owner.builder()
                .firstName("Michael")
                .lastName("Weston")
                .address("123 Filton Grove")
                .city("London")
                .telephone("457 66455 34").build();

        Pet owner2Pet = Pet.builder()
                .petType(catType)
                .birthDate(LocalDate.now())
                .name("Whiskers")
                .build();

        owner2Pet.setOwner(owner2);
        owner2.getPets().add(owner2Pet);

        this.ownerService.save(owner2);

        System.out.println("loaded Owners ...");
    }
}
