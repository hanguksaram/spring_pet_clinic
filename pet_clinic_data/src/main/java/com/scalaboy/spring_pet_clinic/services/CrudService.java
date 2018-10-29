package com.scalaboy.spring_pet_clinic.services;

import com.scalaboy.spring_pet_clinic.model.BaseEntity;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

}
