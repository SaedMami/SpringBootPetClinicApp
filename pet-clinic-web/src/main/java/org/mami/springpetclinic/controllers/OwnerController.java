package org.mami.springpetclinic.controllers;

import org.mami.springpetclinic.services.crud.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner")
public class OwnerController {
    private OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @RequestMapping("")
    public String listOwners(Model model) {
        model.addAttribute("owners", this.ownerService.findAll());
        return "owner/index";
    }

    @RequestMapping("/find")
    public String findOwners(Model model) {
         return "notimplemented";
    };
}
