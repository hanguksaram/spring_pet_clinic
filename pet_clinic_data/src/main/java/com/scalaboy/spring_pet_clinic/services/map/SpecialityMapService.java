package com.scalaboy.spring_pet_clinic.services.map;

import com.scalaboy.spring_pet_clinic.model.Speciality;
import com.scalaboy.spring_pet_clinic.services.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapService extends MapService<Speciality> implements SpecialityService {
}
