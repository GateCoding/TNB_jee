package emsi.cg.redevable.ws;

import emsi.cg.redevable.entity.Redevable;
import emsi.cg.redevable.entity.Terrain;
import emsi.cg.redevable.service.RedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
@RestController
@RequestMapping("api/redevable")
public class RedevableController {

    @Autowired
    RedevableService rc;

    @PostMapping("/save")
    public void saveRedevable(@RequestBody Redevable redevable){
        rc.save(redevable);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRedevable(@PathVariable("id") long id){
        rc.delete(id);
    }

    @PutMapping("/update")
    public void updateRedevable(@RequestBody Redevable redevable){rc.update(redevable);}

    @GetMapping("/all")
    public List<Redevable> getAllRedevables(){
        return rc.findAll();
    }

    @GetMapping("/terrains")
    public List<Terrain> getAllTerrain(@RequestBody Redevable redevable){
        return rc.findAllTerrain(redevable);
    }

    @GetMapping("/findByCin/{cin}")
    public Redevable getRedevableByCin(@PathVariable("cin") String cin) {
        return this.rc.findByCin(cin);
    }

    @GetMapping("/findById/{id}")
    public Redevable getRedevableById(@PathVariable("id") long id) {
        return this.rc.findById(id);
    }

}
