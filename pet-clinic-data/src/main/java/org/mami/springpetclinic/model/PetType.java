package org.mami.springpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PetType extends BaseEntity<Long> {
    private String name;
}
