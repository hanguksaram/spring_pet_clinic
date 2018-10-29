package com.scalaboy.spring_pet_clinic.services.map;

import com.scalaboy.spring_pet_clinic.model.Owner;
import com.scalaboy.spring_pet_clinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerMapService extends MapService<Owner> implements OwnerService {
    @Override
    public Optional<Owner> findByLastName(String lastName) {
        return this.map.values().stream().filter(owner -> owner
                .getLastName().equals(lastName)).findFirst();
    }
}
