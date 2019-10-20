package org.mami.springpetclinic.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person extends BaseEntity<Long> {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
