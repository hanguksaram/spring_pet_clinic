package com.scalaboy.spring_pet_clinic.services.springdatajpa;

import com.scalaboy.spring_pet_clinic.model.PetType;
import com.scalaboy.spring_pet_clinic.repositories.PetTypeRepository;
import com.scalaboy.spring_pet_clinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("db_peristance")
public class PetTypeJpaService extends JpaService<PetType> implements PetTypeService {


    public PetTypeJpaService(PetTypeRepository petTypeRepository) {
        super(petTypeRepository);
    }
}
