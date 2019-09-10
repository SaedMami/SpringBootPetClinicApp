package org.mami.springpetclinic.bootstrap;

import org.mami.springpetclinic.model.Owner;
import org.mami.springpetclinic.model.Vet;
import org.mami.springpetclinic.services.crud.OwnerService;
import org.mami.springpetclinic.services.crud.VetService;
import org.mami.springpetclinic.services.crud.map.OwnerServiceMap;
import org.mami.springpetclinic.services.crud.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Fionna");
        owner1.setLastName("Gelennane");

        this.ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Michael");
        owner2.setLastName("Weston");

        this.ownerService.save(owner2);

        System.out.println("loaded Owners ...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setFirstName("Axe");

        this.vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Ace");
        vet1.setFirstName("Ventura");

        this.vetService.save(vet2);

        System.out.println("loaded Vets ...");
    }
}
