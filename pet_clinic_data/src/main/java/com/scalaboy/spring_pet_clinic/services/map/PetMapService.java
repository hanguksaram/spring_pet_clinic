package com.scalaboy.spring_pet_clinic.services.map;

import com.scalaboy.spring_pet_clinic.model.Pet;
import com.scalaboy.spring_pet_clinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends MapService<Pet> implements PetService {
}
