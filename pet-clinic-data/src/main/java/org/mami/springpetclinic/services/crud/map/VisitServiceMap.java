package org.mami.springpetclinic.services.crud.map;

import org.mami.springpetclinic.model.Visit;
import org.mami.springpetclinic.services.crud.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceMap extends AbstractMapCrudService<Visit> implements VisitService {
}
