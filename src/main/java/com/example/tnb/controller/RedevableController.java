package com.example.tnb.controller;

import com.example.tnb.entity.Redevable;
import com.example.tnb.service.RedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class RedevableController {
    @Autowired
    RedevableService rc;

    @PostMapping("/redevable/save")
    public void SaveRedevable(@RequestBody Redevable redevable){
        System.out.println("test : "+redevable);
        rc.save(redevable);
    }

    @GetMapping("/redevables")
    public List<Redevable> getAllRedevables(){
//        System.out.println("test : "+redevable);
        return rc.findAll();
    }

}
