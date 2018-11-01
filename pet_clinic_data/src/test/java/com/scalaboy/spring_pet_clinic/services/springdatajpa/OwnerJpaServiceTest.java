package com.scalaboy.spring_pet_clinic.services.springdatajpa;

import com.scalaboy.spring_pet_clinic.model.Owner;
import com.scalaboy.spring_pet_clinic.repositories.OwnerRepository;
import com.scalaboy.spring_pet_clinic.repositories.PetRepository;
import com.scalaboy.spring_pet_clinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks//injects mock dependencies into annotated field constructor
    OwnerJpaService ownerJpaService;
    Owner petya, vasya;


    @BeforeEach
    void setUp() {
        petya = Owner.builder().id(1L).lastName("testoff").build();
        vasya = Owner.builder().id(2L).lastName("testoff1").build();
    }

    @Test
    void findByLastName() {


        when(ownerRepository.findByLastName(any())).thenReturn(Optional.ofNullable(petya));

        Owner testoff = ownerJpaService.findByLastName("testoff").get();
        assertEquals("testoff", testoff.getLastName());

    }

    @Test
    void findAll() {
        when(ownerRepository.findAll()).thenReturn(new HashSet<>(Arrays.asList(petya, vasya)));

        Set<Owner> owner = ownerJpaService.findAll();

        assertEquals(2, owner.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.ofNullable(petya));

        Owner fromService = ownerJpaService.findById(1L).get();

        assertEquals(petya, fromService);


    }
    //P.S.actually i dont see any profit doing such testing thing when u mocking method logic and explicitly declares what should it return...Only check proprer interaction between ojects like Service and Repository
    @Test
    void findByValue() {
    }

    @Test
    void save() {
    }

    @Test
    void saveAll() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}