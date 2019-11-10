package org.mami.springpetclinic.model;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PetType extends BaseEntity<Long> {

    private String name;
}
