package emsi.cg.terrain.service;

import emsi.cg.terrain.entity.*;
import emsi.cg.terrain.repository.TaxeRepository;
import emsi.cg.terrain.rmq.DemandePaiementProducer;
import emsi.cg.terrain.rmq.MQConfig;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxeService {

    @Autowired
    private TaxeRepository tr;
    @Autowired
    private RedevableMS redevableServices;
   @Autowired
    private TerrainService terrainServices;
    @Autowired
    private TauxService tauxService;
    @Autowired
    private CategorieService categorieServices;
    @Autowired
    RabbitTemplate template;

    public Taxe save(Taxe o) {

        Redevable redevable = redevableServices.getRedevableByCin(o.getRedevablecin());
        Terrain terrain =  terrainServices.findById(o.getTerrain().getId());
        Categorie categorie = categorieServices.findById(o.getCategorie().getId());
        Taux taux = tauxService.findById(o.getTaux().getId());

        if (redevable ==null || terrain==null){
            System.out.println("redevable or terrain not exist");
            return null;}
        if (taux ==null || categorie==null){
            System.out.println("taux or categorie not exist");
            return null;}

        double surface = o.getTerrain().getSurface();
        double prix= o.getTaux().getPrix();
        o.setCost(prix * surface);

//         Set the related entities
        o.setRedevable(redevable);
        o.setTerrain(terrain);
        o.setCategorie(categorie);
        o.setTaux(taux);
        return tr.save(o);
    }

    public void update(Taxe o) {
        tr.save(o);
    }

    public void delete(Taxe id) {
        tr.delete(id);
    }

    public Taxe findById(long id) {
        return tr.findById(id);
    }

    public List<Taxe> findAll() {
        return tr.findAll();
    }






    public boolean demandeExists(long demandeTaxe) {
        List<Taxe> taxes = tr.findAll();

        for (Taxe taxe : taxes) {
            if (taxe.getId()==demandeTaxe) {
                // La taxe existe déjà dans la liste
                return true;
            }
        }

        // La taxe n'existe pas dans la liste
        return false;
    }

    public String traiterDemandePaiement(DemandePaiementProducer demande) {
        String reponse = demande.getReponseDemande();

             // Vérifier si la demande.getTaxe existe déjà
        if (demandeExists(demande.getTaxe())) {

            demande.setReponseDemande("La demande existe déjà");
            return reponse;
        }

        Taxe taxeUpdate = tr.findById(demande.getTaux());

                taxeUpdate.setPay(true);
                tr.save(taxeUpdate);

      //  reponse.setTraitementReussi(true);
        demande.setReponseDemande("Traitement réussi");

        return reponse;

    }






}