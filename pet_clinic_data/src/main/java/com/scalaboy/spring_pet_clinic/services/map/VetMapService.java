package com.scalaboy.spring_pet_clinic.services.map;

import com.scalaboy.spring_pet_clinic.model.Vet;
import com.scalaboy.spring_pet_clinic.services.CrudService;
import com.scalaboy.spring_pet_clinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends MapService<Vet> implements CrudService<Vet, Long> {
}
