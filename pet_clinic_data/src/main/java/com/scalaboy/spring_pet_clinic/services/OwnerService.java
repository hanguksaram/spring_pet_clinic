package com.scalaboy.spring_pet_clinic.services;

import com.scalaboy.spring_pet_clinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}