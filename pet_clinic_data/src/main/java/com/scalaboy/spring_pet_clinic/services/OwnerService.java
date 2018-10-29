package com.scalaboy.spring_pet_clinic.services;

import com.scalaboy.spring_pet_clinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface OwnerService extends CrudService<Owner, Long> {

    Optional<Owner> findByLastName(String lastName);

}