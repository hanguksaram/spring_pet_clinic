package com.scalaboy.spring_pet_clinic.services.springdatajpa;

import com.scalaboy.spring_pet_clinic.model.Speciality;
import com.scalaboy.spring_pet_clinic.repositories.SpecialityRepository;
import com.scalaboy.spring_pet_clinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@Profile("db_persistence")
public class SpecialityJpaService extends JpaService<Speciality> implements SpecialityService {


    public SpecialityJpaService(SpecialityRepository specialityRepository) {
        super(specialityRepository);
    }
}
