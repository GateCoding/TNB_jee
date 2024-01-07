package com.example.tnb.ws;

import com.example.tnb.entity.Taux;
import com.example.tnb.service.TauxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TauxController {

    @Autowired
    TauxService ts;

    @GetMapping("/taux")
    public List<Taux> getAllTaux(){
        return ts.findAll();
    }

    @PostMapping("taux/save")
    public void saveTaux (@RequestBody Taux t){
        ts.save(t);
    }

}
