package com.scalaboy.spring_pet_clinic.repositories;

import com.scalaboy.spring_pet_clinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Optional<Owner> findByLastName(String lastName);
}
