package org.mami.springpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
public class Pet extends BaseEntity<Long> {

    private LocalDate birthDate;
    private String name;

    @ManyToOne
    private final PetType petType;

    @ManyToOne
    @Setter
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    @Setter
    private Set<Visit> visits = new HashSet<>();

    @Builder
    public Pet(String name, LocalDate birthDate, PetType petType) {
        this.name = name;
        this.birthDate = birthDate;
        this.petType = petType;
    }
}
