package com.scalaboy.spring_pet_clinic.bootstrap;

import com.scalaboy.spring_pet_clinic.model.Owner;
import com.scalaboy.spring_pet_clinic.model.Vet;
import com.scalaboy.spring_pet_clinic.services.CrudService;
import com.scalaboy.spring_pet_clinic.services.OwnerService;
import com.scalaboy.spring_pet_clinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final CrudService<Vet, Long> vetService;

    public DataLoader(OwnerService ownerService, CrudService<Vet, Long> vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("LOL");
        owner1.setLastName("KEKOVICH");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("KEK");
        owner2.setLastName("LOLEVICH");


        ownerService.save(owner2);

        System.out.println("Owners loaded");
        Vet vet1 = new Vet();
        vet1.setFirstName("LAL");
        vet1.setLastName("KIKAVICH");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("KIK");
        vet2.setLastName("LALEVICH");

        vetService.save(vet2);

        System.out.println("Vets loaded");

    }
}
