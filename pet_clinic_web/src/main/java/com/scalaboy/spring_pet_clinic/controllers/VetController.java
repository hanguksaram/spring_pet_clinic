package com.scalaboy.spring_pet_clinic.controllers;

import com.scalaboy.spring_pet_clinic.model.Vet;
import com.scalaboy.spring_pet_clinic.services.CrudService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final CrudService<Vet, Long> vetService;

    public VetController(CrudService<Vet, Long> vetService) {
        this.vetService = vetService;
    }

    @RequestMapping("/vets")
    public String index(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
