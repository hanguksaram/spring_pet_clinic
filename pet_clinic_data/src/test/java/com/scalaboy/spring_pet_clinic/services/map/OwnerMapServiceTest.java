package com.scalaboy.spring_pet_clinic.services.map;

import com.scalaboy.spring_pet_clinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    OwnerMapService ownerMapService1;
    Owner petya = Owner.builder().lastName("Testoff").id(1L).build();
    @BeforeEach
    void setUp() {

        ownerMapService = new OwnerMapService();
        Owner owner1 = Owner.builder().lastName("Testoff").id(1L).build();
        Owner owner2 = Owner.builder().lastName("Testoff1").id(2L).build();
        ownerMapService.map.put(1L, owner1);
        ownerMapService.map.put(2L, owner2);

        ownerMapService1 = new OwnerMapService();
    }

    @Test
    void findByLastName() {
         Optional<Owner> fromService = ownerMapService.findByLastName(petya.getLastName());
         assertEquals(petya, fromService.get());

    }
    @Test
    void findByLastNameNot() {
        Optional<Owner> fromService = ownerMapService.findByLastName("vasiliev");
        assertNull(fromService.orElse(null));

    }

    @Test
    void findNothing(){
        Set<Owner> owners = ownerMapService1.findAll();
        assertEquals(0, owners.size());

    }
    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        Optional<Owner> fromService = ownerMapService.findById(1L);
        assertEquals(petya, fromService.get());
    }
    @Test
    void findByIdNot() {
        Optional<Owner> fromService = ownerMapService.findById(3L);
        assertNull(fromService.orElse(null));
    }

    @Test
    void findByValue() {
        Optional<Owner> fromService = ownerMapService.findByValue(petya);
        assertEquals(petya, fromService.get());
    }

    @Test
    void save() {
        Owner fromService = ownerMapService.save(Owner.builder().build());
        assertEquals(fromService.getId(), Long.valueOf(ownerMapService.map.size()));
    }

    @Test
    void saveAll() {
        Owner owner1 = Owner.builder().lastName("Testoff3").build();
        Owner owner2 = Owner.builder().lastName("Testoff4").build();
        assertTrue(ownerMapService.saveAll(Arrays.asList(owner1, owner2)));
        assertEquals(owner1, ownerMapService.findByLastName("Testoff3").get());
        assertEquals(owner2, ownerMapService.findByLastName("Testoff4").get());

    }

    @Test
    void delete() {
        ownerMapService.delete(petya);
        assertNull(ownerMapService.findByValue(petya).orElse(null));
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(1L);
        assertNull(ownerMapService.findByValue(petya).orElse(null));
    }
}