package com.example.tnb.ws;

import com.example.tnb.entity.Redevable;
import com.example.tnb.entity.Terrain;
import com.example.tnb.service.RedevableService;
import com.example.tnb.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TerrainController {

    @Autowired
    TerrainService ts;
    @Autowired
    RedevableService rs;

    @GetMapping("/terrain")
    public List<Terrain> getAllTerrain(){
        return ts.findAll();
    }

    @PostMapping("/terrain/save")
    public void saveTerrain(@RequestBody Terrain t){
        ts.save(t);
    }

    @GetMapping("/terrain/redevable")
    public List<Terrain> getTerrainByRevendevale(@RequestParam("cin") String cin){
        return ts.findByRedevableCin(cin);
    }
}
