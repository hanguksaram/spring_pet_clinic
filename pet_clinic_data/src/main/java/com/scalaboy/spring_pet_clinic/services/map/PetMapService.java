package com.scalaboy.spring_pet_clinic.services.map;

import com.scalaboy.spring_pet_clinic.model.Pet;
import com.scalaboy.spring_pet_clinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetMapService extends MapService<Pet> implements PetService {
}
