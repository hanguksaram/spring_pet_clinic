package com.scalaboy.spring_pet_clinic.services.map;

import com.scalaboy.spring_pet_clinic.model.BaseEntity;
import com.scalaboy.spring_pet_clinic.services.CrudService;
import org.springframework.stereotype.Service;


import java.util.*;




public abstract class MapService<T extends BaseEntity> implements CrudService<T, Long> {

    protected Map<Long ,T>  map = new HashMap<>();

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public Optional<T> findById(Long id) {
         return Optional.ofNullable(map.getOrDefault(id, null));
    }

    @Override
    public Optional<T> findByValue(T object) {
        return this.map.values().stream().filter(x -> x.equals(object)).findFirst();
    }

    @Override
    public T save(T object) {

        if(object != null) {
            if(object.getId() == null) {
                object.setId(this.getNextId());

            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    @Override
    public boolean saveAll(Iterable<T> objects) {
        Long nextId = this.getNextId();
        Long count = -1L;
        try {
            objects.forEach(obj -> this.map.put( + nextId, obj));
        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;

    }

    @Override
    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    public void deleteById(Long id){
        map.remove(id);
    }

    private Long getNextId() {

        return !map.isEmpty() ? Collections.max(map.keySet()) + 1 : 1;

    }

}
