package emsi.cg.terrain.ws;

import emsi.cg.terrain.entity.Terrain;
//import emsi.cg.terrain.service.RedevableService;
import emsi.cg.terrain.service.RedevableMS;
import emsi.cg.terrain.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
@RestController
@RequestMapping("api/terrain")
public class TerrainController {

    @Autowired
    TerrainService ts;
//    @Autowired
//    RedevableMS rs;

    @GetMapping("/all")
    public List<Terrain> getAllTerrain(){
        return ts.findAll();
    }

    @PostMapping("/save")
    public void saveTerrain(@RequestBody Terrain t){
        ts.save(t);
    }

    @GetMapping("/redevable/{cin}")
    public List<Terrain> getTerrainByRedevable(@PathVariable("cin") String cin){
        return ts.findByRedevableCin(cin);
    }

    @GetMapping("/find/{id}")
    public Terrain getTerrainById(@PathVariable("id") long id){
        return ts.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTerrain(@PathVariable("id") long id){
        ts.delete(ts.findById(id));
    }

    @PutMapping("/update")
    public void updateTerrain(@RequestBody Terrain t){ts.update(t);}

}
