package com.scalaboy.spring_pet_clinic.services.springdatajpa;

import com.scalaboy.spring_pet_clinic.model.BaseEntity;
import com.scalaboy.spring_pet_clinic.services.CrudService;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class JpaService<T extends BaseEntity> implements CrudService<T, Long> {


    protected final CrudRepository<T, Long> crudRepository;

    protected JpaService(CrudRepository<T, Long> crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public Set<T> findAll() {
        return StreamSupport.stream(this.crudRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public Optional<T> findById(Long id) {
        return this.crudRepository.findById(id);
    }

    @Override
    public Optional<T> findByValue(T object) {
        return StreamSupport.stream(this.crudRepository.findAll().spliterator(),false).filter(x -> x.equals(object)).findFirst();

    }

    @Override
    public T save(T object) {
        return this.crudRepository.save(object);
    }

    @Override
    public boolean saveAll(Iterable<T> objectsDto) {
        Iterable<T> objectPersistance = this.crudRepository.saveAll(objectsDto);
        return StreamSupport.stream(objectPersistance.spliterator(), false).count() != 0;
    }

    @Override
    public void delete(T object) {
        this.crudRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        this.crudRepository.deleteById(id);
    }
}
