package com.scalaboy.spring_pet_clinic.repositories;

import com.scalaboy.spring_pet_clinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
