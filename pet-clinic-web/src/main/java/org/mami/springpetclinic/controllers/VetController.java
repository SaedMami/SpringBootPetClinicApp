package org.mami.springpetclinic.controllers;

import org.mami.springpetclinic.services.crud.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vet")
public class VetController {

    private VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping("")
    public String listVets(Model model) {
        model.addAttribute("vets", this.vetService.findAll());
        return "vet/index";
    }
}
