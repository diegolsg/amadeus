package com.amadeus.horas_extras.adapter.api.controller;

import com.amadeus.horas_extras.domain.model.ExtrasHoursModel;
import com.amadeus.horas_extras.domain.port.service.ExtraHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@RestController
@RequestMapping("/horas")
public class ExtraHoursController {
    private final ExtraHoursService extraHoursService;

    @Autowired
    public ExtraHoursController(ExtraHoursService extraHoursService) {
        this.extraHoursService = extraHoursService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ExtrasHoursModel>> getAllHours() {
        List<ExtrasHoursModel> hours = extraHoursService.getAllHours();
        return new ResponseEntity<>(hours, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ExtrasHoursModel> saveHours(@RequestBody ExtrasHoursModel extraHours) {
        ExtrasHoursModel savedHours = extraHoursService.saveHours(extraHours);
        return new ResponseEntity<>(savedHours, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ExtrasHoursModel> updateHours(@RequestBody ExtrasHoursModel extraHours) {
        ExtrasHoursModel updatedHours = extraHoursService.updateHours(extraHours);
        return new ResponseEntity<>(updatedHours, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Void> deleteHours(@Param("id") int idExtraHours) {
        extraHoursService.deleteHours(idExtraHours);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/fechas")
    public ResponseEntity<List<ExtrasHoursModel>> getHoursByDate(@RequestParam String startDate,
                                                                 @RequestParam String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        LocalDateTime startDateTime = LocalDateTime.parse(startDate, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate, formatter);

        List<ExtrasHoursModel> hours = extraHoursService.getHoursByDate(startDateTime, endDateTime);
        return new ResponseEntity<>(hours, HttpStatus.OK);
    }

    @GetMapping("/documento")
    public ResponseEntity<List<ExtrasHoursModel>> getHoursByDocument(@Param("document") String document) {
        List<ExtrasHoursModel> hours = extraHoursService.getHoursByDocument(document);
        return new ResponseEntity<>(hours, HttpStatus.OK);
    }
}

