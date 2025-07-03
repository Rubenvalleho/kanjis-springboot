package com.rubenvj.springboot.kanjis.kanjis_springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PruebaController {

    @GetMapping("/prueba")
    public String prueba() {
        return "prueba";
    }
}
