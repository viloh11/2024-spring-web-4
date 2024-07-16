package org.java.spring_web4.db.service;

import java.util.List;
import java.util.Optional;

import org.java.spring_web4.db.pojo.Farm;
import org.java.spring_web4.db.repo.FarmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmService {

    @Autowired
    private FarmRepo farmRepository;

    public List<Farm> findAll(){
        return farmRepository.findAll();
    }

    public Optional<Farm> getById(int id){
        return farmRepository.findById(id);
    }

    public void save(Farm farm){
        farmRepository.save(farm);
    }

    public void delete(Farm farm){
        farmRepository.delete(farm);
    }
}
