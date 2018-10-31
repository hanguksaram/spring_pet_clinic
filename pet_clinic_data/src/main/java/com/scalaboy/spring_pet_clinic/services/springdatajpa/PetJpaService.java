package com.scalaboy.spring_pet_clinic.services.springdatajpa;

import com.scalaboy.spring_pet_clinic.model.Pet;
import com.scalaboy.spring_pet_clinic.repositories.PetRepository;
import com.scalaboy.spring_pet_clinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("db_peristance")
public class PetJpaService extends JpaService<Pet> implements PetService {


    public PetJpaService(PetRepository petRepository) {
        super(petRepository);
    }
}
