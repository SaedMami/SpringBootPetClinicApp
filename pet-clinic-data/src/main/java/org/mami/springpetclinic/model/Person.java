package org.mami.springpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
abstract class Person extends BaseEntity<Long> {
    private String firstName;
    private String lastName;
}
