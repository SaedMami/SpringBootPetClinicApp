package org.mami.springpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Specialty> specialties = new HashSet<>();
}
