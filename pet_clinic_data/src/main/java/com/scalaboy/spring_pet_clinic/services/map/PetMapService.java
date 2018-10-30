package com.scalaboy.spring_pet_clinic.services.map;

import com.scalaboy.spring_pet_clinic.model.PetType;
import com.scalaboy.spring_pet_clinic.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends MapService<PetType> implements CrudService<PetType, Long> {
}
