package com.scalaboy.spring_pet_clinic.services.springdatajpa;

import com.scalaboy.spring_pet_clinic.model.Vet;
import com.scalaboy.spring_pet_clinic.repositories.VetRepository;
import com.scalaboy.spring_pet_clinic.services.CrudService;
import com.scalaboy.spring_pet_clinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@Profile("db_peristance")
public class VetJpaService extends JpaService<Vet> implements VetService {

    public VetJpaService(VetRepository vetRepository) {
        super(vetRepository);
    }
}
