package emsi.cg.terrain.service;

import emsi.cg.terrain.entity.*;
import emsi.cg.terrain.repository.TaxeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}