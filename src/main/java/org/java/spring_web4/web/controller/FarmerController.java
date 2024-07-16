package org.java.spring_web4.web.controller;

import java.util.List;
import java.util.Optional;

import org.java.spring_web4.db.pojo.Farmer;
import org.java.spring_web4.db.service.FarmerService;
import org.java.spring_web4.web.dto.FarmerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("farmer")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @GetMapping("/test/add")
    public ResponseEntity<Void> addFarmer(){
        Farmer f1 = new Farmer("Mario", "Rossi", 30, "Fattoria 1");
        Farmer f2 = new Farmer("Giovanni", "Simonetti", 40, "Fattoria 2");

        farmerService.save(f1);
        farmerService.save(f2);

        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Farmer>> getAllFarmer(){
        List<Farmer> farmers = farmerService.findAll();
        
        return ResponseEntity.ok(farmers);
    }

    @PostMapping("")
    public ResponseEntity<Farmer> addFarmer(@RequestBody FarmerDto farmerDto){
        Farmer farmer = new Farmer(farmerDto);
        farmerService.save(farmer);

        return ResponseEntity.ok(farmer);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Farmer> updateFarmer(@PathVariable int id, @RequestBody FarmerDto farmerDto){
        Optional<Farmer> optFarmer = farmerService.getById(id);
        if((optFarmer.isEmpty()))
            return ResponseEntity.notFound().build();

        Farmer farmer = optFarmer.get();
        farmer.update(farmerDto);
        farmerService.save(farmer);

        return ResponseEntity.ok(farmer);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFarmer(@PathVariable int id){
        Optional<Farmer> optFarmer = farmerService.getById(id);

        if(optFarmer.isEmpty())
            return ResponseEntity.notFound().build();

        Farmer farmer = optFarmer.get();
        farmerService.delete(farmer);

        return ResponseEntity.ok().build();
    }
}
