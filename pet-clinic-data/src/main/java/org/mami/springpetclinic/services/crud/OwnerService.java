package org.mami.springpetclinic.services.crud;

import org.mami.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
