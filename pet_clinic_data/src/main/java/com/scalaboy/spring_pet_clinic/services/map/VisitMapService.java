package com.scalaboy.spring_pet_clinic.services.map;

import com.scalaboy.spring_pet_clinic.model.Visit;
import com.scalaboy.spring_pet_clinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VisitMapService extends MapService<Visit> implements VisitService {
}
