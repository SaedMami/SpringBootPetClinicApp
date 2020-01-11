package org.mami.springpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Specialty> specialties = new HashSet<>();

    @Builder
    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
