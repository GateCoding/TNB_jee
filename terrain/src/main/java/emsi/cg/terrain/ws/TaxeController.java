package emsi.cg.terrain.ws;

import emsi.cg.terrain.entity.Taxe;

import emsi.cg.terrain.repository.DemandeRepository;
import emsi.cg.terrain.rmq.DemandePaiementProducer;
import emsi.cg.terrain.service.TaxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
@RestController
@RequestMapping("api")
public class TaxeController {

    @Autowired
    TaxeService ts;
    @Autowired
    DemandeRepository demandeRepository;

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
    @GetMapping(path = "/taxe/find/{id}")
    Taxe taxebyId (@PathVariable("id") Long id){
      return   ts.findById(id);
    }


    @GetMapping(path = "/demande")
    public List<DemandePaiementProducer> listDemandes( ) {
        return demandeRepository.findAll();
    }

    @GetMapping(path = "/demande/find/{is}")
    public DemandePaiementProducer demandebyId(@PathVariable("id") Long id ) {
        return demandeRepository.findById(id);
    }

    @PostMapping(path = "/demande/taiter")
    String traiterDemandePaiement(@RequestBody DemandePaiementProducer demande){
        ts.traiterDemandePaiement(demande);
        return demande.getReponseDemande();
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