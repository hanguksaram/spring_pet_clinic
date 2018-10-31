package com.scalaboy.spring_pet_clinic.services.springdatajpa;

import com.scalaboy.spring_pet_clinic.model.Owner;
import com.scalaboy.spring_pet_clinic.repositories.OwnerRepository;
import com.scalaboy.spring_pet_clinic.repositories.PetRepository;
import com.scalaboy.spring_pet_clinic.repositories.PetTypeRepository;
import com.scalaboy.spring_pet_clinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@Profile("db_persistence")
public class OwnerJpaService extends JpaService<Owner> implements OwnerService {

    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        super(ownerRepository);
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Optional<Owner> findByLastName(String lastName) {
        return ((OwnerRepository)super.crudRepository).findByLastName(lastName);
    }


}
