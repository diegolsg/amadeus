package com.amadeus.horas_extras.adapter.api.controller;

import com.amadeus.horas_extras.domain.model.BossModel;
import com.amadeus.horas_extras.domain.port.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class BossController {

    private final BossService bossService;
    @Autowired
    public BossController(BossService bossService) {
        this.bossService = bossService;
    }

    @GetMapping("/listarAdmin")
    public ResponseEntity<List<BossModel>> getBosses() {

        try {
            List<BossModel> bosses = bossService.getBoss();
            if (bosses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bosses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
