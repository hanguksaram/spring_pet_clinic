package com.scalaboy.spring_pet_clinic.services.springdatajpa;

import com.scalaboy.spring_pet_clinic.model.Visit;
import com.scalaboy.spring_pet_clinic.repositories.VisitRepository;
import com.scalaboy.spring_pet_clinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@Profile("db_peristance")
public class VisitJpaService extends JpaService<Visit> implements VisitService {

    public VisitJpaService(VisitRepository visitRepository) {
        super(visitRepository);
    }
}


