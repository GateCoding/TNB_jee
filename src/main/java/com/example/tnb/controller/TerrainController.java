package com.example.tnb.controller;

import com.example.tnb.entity.Terrain;
import com.example.tnb.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TerrainController {

    @Autowired
    TerrainService ts;

    @GetMapping("/terrain")
    public List<Terrain> getAllTerrain(){
        return ts.findAll();
    }

    @PostMapping("/terrain/save")
    public void saveTerrain(@RequestBody Terrain t){
        ts.save(t);
    }

}
