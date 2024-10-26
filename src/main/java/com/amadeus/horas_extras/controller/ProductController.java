package com.amadeus.horas_extras.controller;

import com.amadeus.horas_extras.adapter.daos.entity.Employ;
import com.amadeus.horas_extras.domain.port.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProductController {

    private EmployService employService;

    @Autowired
    public ProductController(EmployService employService) {
        this.employService = employService;
    }

    @GetMapping ("/listEmploy")
    public List<Employ> listEmploy() {
        return employService.getEmployees();
    }
    @PostMapping ("/saveEmploy")
    public Employ saveEmploy(@RequestBody Employ employ) {
        return employService.save(employ);
    }
}
