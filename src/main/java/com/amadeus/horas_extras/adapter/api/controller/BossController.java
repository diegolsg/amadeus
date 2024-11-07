package com.amadeus.horas_extras.adapter.api.controller;

import com.amadeus.horas_extras.domain.model.BossModel;
import com.amadeus.horas_extras.domain.port.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class BossController {

    private final BossService bossService;

    @Autowired
    public BossController(BossService bossService) {
        this.bossService = bossService;
    }

    @GetMapping
    public ResponseEntity<List<BossModel>> getAllBosses() {
        List<BossModel> bosses = bossService.getAllBosses();
        return new ResponseEntity<>(bosses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BossModel> getBossById(@PathVariable Long id) {
        try {
            BossModel boss = bossService.getBossById(id);
            return new ResponseEntity<>(boss, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BossModel> createBoss(@RequestBody BossModel bossModel) {
        try {
            BossModel createdBoss = bossService.createBoss(bossModel);
            return new ResponseEntity<>(createdBoss, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<BossModel> updateBoss(@PathVariable Long id, @RequestBody BossModel bossModel) {
//        try {
//            bossModel.setId(id);
//            BossModel updatedBoss = bossService.updateBoss(bossModel);
//            return new ResponseEntity<>(updatedBoss, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoss(@PathVariable Long id) {
        try {
            bossService.deleteBoss(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
