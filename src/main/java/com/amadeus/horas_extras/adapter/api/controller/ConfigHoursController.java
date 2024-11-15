package com.amadeus.horas_extras.adapter.api.controller;

import com.amadeus.horas_extras.domain.model.ConfigHoursModel;
import com.amadeus.horas_extras.domain.model.EmployModel;
import com.amadeus.horas_extras.domain.port.service.ConfigHoursService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/configuracion")
public class ConfigHoursController {
    private ConfigHoursService hoursService;
    @Autowired
    public ConfigHoursController(ConfigHoursService hoursService) {
        this.hoursService = hoursService;
    }

    @PostMapping
    public ResponseEntity<ConfigHoursModel> saveConfig(@RequestBody ConfigHoursModel configHoursModel){
        try {
            ConfigHoursModel createdConfig = hoursService.saveConfigHours(configHoursModel);
            return new ResponseEntity<>(createdConfig, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConfigHoursModel> updateConfig(@RequestBody ConfigHoursModel configHoursModel, String id) {
//        try {
//            if (!id.equals(configHoursModel.getId())) {
//                return ResponseEntity.badRequest().build();
//            }
//            ConfigHoursModel updatedConfig = hoursService.updateConfigHour(configHoursModel);
//            return ResponseEntity.ok(updatedConfig);
//        } catch (EntityNotFoundException e) {
//            return ResponseEntity.notFound().build();
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().build();
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().build();
//        }
//    }
        return null;
    }
}
