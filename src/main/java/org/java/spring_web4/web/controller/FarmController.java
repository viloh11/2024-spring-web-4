package org.java.spring_web4.web.controller;

import java.util.List;
import java.util.Optional;

import org.java.spring_web4.db.pojo.Farm;
import org.java.spring_web4.db.service.FarmService;
import org.java.spring_web4.web.dto.FarmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("farm")
public class FarmController {
    @Autowired
    private FarmService farmService;

    @GetMapping("")
    public ResponseEntity<List<Farm>> getAllFarm(){
        List<Farm> farms = farmService.findAll();

        return ResponseEntity.ok(farms);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Farm> updateFarm(@PathVariable int id, @RequestBody FarmDto farmDto){
        Optional<Farm> optFarm = farmService.getById(id);

        if(optFarm.isEmpty())
            return ResponseEntity.notFound().build();

        Farm farm = optFarm.get();
        farm.update(farmDto);
        farmService.save(farm);

        return ResponseEntity.ok(farm);
    }

    @PostMapping("")
    public ResponseEntity<Farm> addFarm(@RequestBody FarmDto farmDto){
        Farm farm = new Farm(farmDto);
        farmService.save(farm);

        return ResponseEntity.ok(farm);
    }

    
}
