package com.example.tnb.ws;

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
    public void saveRedevable(@RequestBody Redevable redevable){
        rc.save(redevable);
    }

    @GetMapping("/redevables")
    public List<Redevable> getAllRedevables(){
        return rc.findAll();
    }

}
