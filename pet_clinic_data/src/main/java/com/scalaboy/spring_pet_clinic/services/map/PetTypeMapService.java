package com.scalaboy.spring_pet_clinic.services.map;

import com.scalaboy.spring_pet_clinic.model.PetType;
import com.scalaboy.spring_pet_clinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends MapService<PetType> implements PetTypeService {
}
