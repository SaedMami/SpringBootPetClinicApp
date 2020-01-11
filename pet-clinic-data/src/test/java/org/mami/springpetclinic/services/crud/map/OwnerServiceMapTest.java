package org.mami.springpetclinic.services.crud.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mami.springpetclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    private OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        this.ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap(new VisitServiceMap()));
    }

    @Test
    void findAll() {
        Owner owner1 = Owner.builder().build();
        Owner owner2 = Owner.builder().build();

        this.ownerServiceMap.save(owner1);
        this.ownerServiceMap.save(owner2);

        Set<Owner> foundOwners = this.ownerServiceMap.findAll();

        assertEquals(2, foundOwners.size());
    }

    @Test
    void findById() {
        Owner owner = Owner.builder().build();
        Long ownerId = 99L;
        owner.setId(ownerId);

        this.ownerServiceMap.save(owner);

        Owner savedOwner = this.ownerServiceMap.findById(ownerId);

        assertEquals(ownerId, savedOwner.getId());
    }


    @Test
    void delete() {
        Owner owner = Owner.builder().build();
        this.ownerServiceMap.save(owner);

        assertEquals(1, this.ownerServiceMap.findAll().size());

        this.ownerServiceMap.delete(owner);

        assertEquals(0, this.ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        Owner owner1 = Owner.builder().build();
        owner1.setId(1L);
        this.ownerServiceMap.save(owner1);

        Owner owner2 = Owner.builder().build();
        owner1.setId(2L);
        this.ownerServiceMap.save(owner2);

        assertEquals(2, this.ownerServiceMap.findAll().size());

        this.ownerServiceMap.deleteById(1L);

        assertNull(this.ownerServiceMap.findById(1L));
        assertEquals(1, this.ownerServiceMap.findAll().size());
    }

    @Test
    void saveGivenId() {
        Owner owner = Owner.builder().build();
        owner.setId(88L);
        this.ownerServiceMap.save(owner);

        assertNotNull(this.ownerServiceMap.findById(88L));
    }

    @Test
    void saveNoId() {
        Owner owner = Owner.builder().build();
        this.ownerServiceMap.save(owner);

        assertNotNull(owner.getId());
        assertNotNull(this.ownerServiceMap.findById(owner.getId()));
    }

    @Test
    void findByLastName() {
        Owner owner = Owner.builder().lastName("Mami").build();
        this.ownerServiceMap.save(owner);

        Owner found = this.ownerServiceMap.findByLastName("Mami");
        assertNotNull(found);
    }
}