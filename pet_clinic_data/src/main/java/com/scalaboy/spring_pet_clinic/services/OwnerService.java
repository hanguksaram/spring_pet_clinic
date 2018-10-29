package com.scalaboy.spring_pet_clinic.services;

import com.scalaboy.spring_pet_clinic.model.Owner;
import org.springframework.data.repository.CrudRepository;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}