package org.mami.springpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
class Person extends BaseEntity<Long> {
    private String firstName;
    private String lastName;
}
