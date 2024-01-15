package emsi.cg.terrain.ws;

import emsi.cg.terrain.entity.Taxe;
import emsi.cg.terrain.repository.DemandeRepository;
import emsi.cg.terrain.rmq.DemandePaiementProducer;
import emsi.cg.terrain.service.TaxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/taxe/save")
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

}