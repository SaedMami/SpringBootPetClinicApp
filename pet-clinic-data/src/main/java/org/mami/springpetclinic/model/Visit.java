package org.mami.springpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Visit extends BaseEntity<Long> {

    private LocalDate date;
    private String description;

    @ManyToOne
    private Pet pet;
}
