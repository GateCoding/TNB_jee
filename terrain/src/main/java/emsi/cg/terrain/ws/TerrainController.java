package emsi.cg.terrain.ws;

import emsi.cg.terrain.entity.Terrain;
//import emsi.cg.terrain.service.RedevableService;
import emsi.cg.terrain.service.RedevableMS;
import emsi.cg.terrain.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TerrainController {

    @Autowired
    TerrainService ts;
//    @Autowired
//    RedevableMS rs;

    @GetMapping("/terrain")
    public List<Terrain> getAllTerrain(){
        return ts.findAll();
    }

    @PostMapping("/terrain/save")
    public void saveTerrain(@RequestBody Terrain t){
        ts.save(t);
    }

    @GetMapping("/terrain/redevable/{cin}")
    public List<Terrain> getTerrainByRevendevale(@PathVariable("cin") String cin){
        return ts.findByRedevableCin(cin);
    }
}
