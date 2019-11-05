package org.mami.springpetclinic.services.crud.map;

import org.mami.springpetclinic.model.Specialty;
import org.mami.springpetclinic.services.crud.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialtyServiceMap extends AbstractMapCrudService<Specialty> implements SpecialtyService {

}
