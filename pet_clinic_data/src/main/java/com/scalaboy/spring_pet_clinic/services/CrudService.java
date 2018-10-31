package com.scalaboy.spring_pet_clinic.services;

import com.scalaboy.spring_pet_clinic.model.BaseEntity;

import java.util.Optional;
import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();

    Optional<T> findById(ID id);

    Optional<T> findByValue(T object);

    T save(T object);

    boolean saveAll(Iterable<T> objects);

    void delete(T object);

    void deleteById(ID id);

}
