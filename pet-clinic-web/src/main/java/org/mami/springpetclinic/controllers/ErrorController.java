package org.mami.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oups")
public class ErrorController {
    @RequestMapping("")
    public String error() {
        return "notimplemented";
    }
}
