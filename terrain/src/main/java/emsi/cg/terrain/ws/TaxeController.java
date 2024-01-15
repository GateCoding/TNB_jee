package emsi.cg.terrain.ws;

import emsi.cg.terrain.entity.Taxe;
import emsi.cg.terrain.entity.Terrain;
import emsi.cg.terrain.service.TaxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
@RestController
@RequestMapping("api/taxe")
public class TaxeController {

    @Autowired
    TaxeService ts;

    @GetMapping("/taxe")
    public List<Taxe> getAllTaxe(){
        return ts.findAll();
    }

    @GetMapping("/redevable/{cin}")
    public List<Taxe> getTaxesByRevendevale(@PathVariable("cin") String cin){
        return ts.findByTaxeCin(cin);
    }

//    @GetMapping("/findByTerrain/{id}")
//    public List<Terrain> getTerrainByRedevable(@PathVariable("id") long id){
//        return ts.(id);
//    }

    @PostMapping("/save")
    public void saveTaxe(@RequestBody Taxe t){
        ts.save(t);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTaxe(@PathVariable("id") long id){
        ts.delete(ts.findById(id));
    }

    @PutMapping("/update")
    public void updateTaxe(@RequestBody Taxe t){ts.update(t);}

    @GetMapping("/all")
    public List<Taxe> getAllTaxes(){
        return ts.findAll();
    }

    @GetMapping("/findById/{id}")
    public Taxe getTaxeById(@PathVariable("id") long id) {
        return this.ts.findById(id);
    }

}