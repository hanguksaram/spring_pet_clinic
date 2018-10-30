package com.scalaboy.spring_pet_clinic.bootstrap;

import com.scalaboy.spring_pet_clinic.model.*;
import com.scalaboy.spring_pet_clinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {


    //жвм лол изза стирания типа дженерика спринг контекст инжектит один и тот же объект MapService в качестве реализации для дженериковых сервисов;
    //всем c# пацаны
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      PetService petService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
    }


    @Override
    public void run(String... args) throws Exception {

        if (ownerService.findAll() != null && ownerService.findAll().size() != 0)
            return;
        this.loadData();

    }

    private void loadData() {
        Speciality defaultSpeciality = new Speciality();
        defaultSpeciality.setId(1L);
        defaultSpeciality.setDescriprion("default");
        Speciality radiology = new Speciality();
        radiology.setDescriprion("Radiolgy");
        Speciality surgery = new Speciality();
        surgery.setDescriprion("Surgery");
        specialityService.saveAll(Arrays.asList(radiology, surgery));

        radiology = specialityService.findByValue(radiology).orElse(defaultSpeciality);
        surgery = specialityService.findByValue(surgery).orElse(defaultSpeciality);

        PetType petType1 = new PetType();
        petType1.setName("dog");
        petType1 = this.petTypeService.save(petType1);

        PetType petType2 = new PetType();
        petType1.setName("cat");
        petType2 = this.petTypeService.save(petType2);


        Owner owner1 = new Owner();
        owner1.setFirstName("LOL");
        owner1.setLastName("KEKOVICH");
        owner1.setAddress("lollandia");
        owner1.setCity("miami");
        owner1.setTelephone("123456789");


        Owner owner2 = new Owner();
        owner2.setFirstName("KEK");
        owner2.setLastName("LOLEVICH");
        owner2.setAddress("lollandia");
        owner2.setCity("miami");
        owner2.setTelephone("123456789");

        Pet pet1 = new Pet();
        pet1.setPetType(petType1);
        pet1.setOwner(owner1);
        Pet pet2 = new Pet();
        pet2.setPetType(petType2);
        pet2.setOwner(owner2);
        pet1 = petService.save(pet1);
        pet2 = petService.save(pet2);

        owner1.setPets(new HashSet<>(Arrays.asList(pet1)));
        owner1.setPets(new HashSet<>(Arrays.asList(pet2)));
        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Owners loaded");
        Vet vet1 = new Vet();
        vet1.setFirstName("LAL");
        vet1.setLastName("KIKAVICH");
        vet1.setSpecialities(new HashSet<>(Arrays.asList(surgery)));

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("KIK");
        vet2.setLastName("LALEVICH");
        vet2.setSpecialities(new HashSet<>(Arrays.asList(radiology)));
        vetService.save(vet2);
        Set<Vet> vets =  vetService.findAll();
        System.out.println(vets.size());
        for (Vet vet: vets) {
            System.out.println(vet.getId());
        }

        System.out.println("Vets loaded");
    }
}
