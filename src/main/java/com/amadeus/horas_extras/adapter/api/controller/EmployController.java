package com.amadeus.horas_extras.adapter.api.controller;

import com.amadeus.horas_extras.domain.model.EmployModel;
import com.amadeus.horas_extras.domain.port.service.EmployService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleado")
public class EmployController {
private EmployService employService;

    @Autowired
    
    public EmployController(EmployService employService) {
        this.employService = employService;
    }
    
    @GetMapping
    public ResponseEntity<List<EmployModel>> getAllemployes() {
        List<EmployModel> employes = employService.getEmployes();
        return new ResponseEntity<>(employes, HttpStatus.OK);
    }

    @GetMapping("/{document}")
    public ResponseEntity<Optional<EmployModel>> getemployById(@PathVariable String document) {
        try {
            Optional<EmployModel> employ = employService.findByDocument(document);
            return new ResponseEntity<>(employ, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EmployModel> createemploy(@RequestBody EmployModel employModel) {
        try {
            EmployModel createdemploy = employService.saveEmploy(employModel);
            return new ResponseEntity<>(createdemploy, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{document}")
    public ResponseEntity<EmployModel> updateEmployee(
            @PathVariable String document,
            @RequestBody EmployModel employModel) {
        try {
            if (!document.equals(employModel.getDocument())) {
                return ResponseEntity.badRequest().build();
            }
            EmployModel updatedEmployee = employService.updateEmploy(employModel);
            return ResponseEntity.ok(updatedEmployee);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{document}")
    public ResponseEntity<Void> deleteemploy(@PathVariable String document) {
        try {
            employService.deleteEmploy(document);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
