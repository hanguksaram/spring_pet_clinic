package com.scalaboy.spring_pet_clinic;

import com.scalaboy.spring_pet_clinic.persistance.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringPetClinicApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringPetClinicApplication.class, args);

        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
;
        System.out.println(fakeDataSource.getUrl());
        System.out.println(fakeDataSource.getUser());
        System.out.println(fakeDataSource.getPassword());

    }

}
