package org.mami.springpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Entity
@AllArgsConstructor
@Builder
public class Visit extends BaseEntity<Long> {

    private final LocalDate date;
    private final String description;

    @ManyToOne
    private final Pet pet;
}
