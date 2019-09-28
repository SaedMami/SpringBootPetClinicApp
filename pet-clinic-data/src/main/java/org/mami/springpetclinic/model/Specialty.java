package org.mami.springpetclinic.model;

public class Specialty extends BaseEntity<Long> {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
