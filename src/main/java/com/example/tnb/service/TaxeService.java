package com.example.tnb.service;

import com.example.tnb.dao.IDao;
import com.example.tnb.entity.*;
import com.example.tnb.repository.RedevableRepository;
import com.example.tnb.repository.TaxeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxeService implements IDao<Taxe> {
    @Autowired
    private TaxeRepository tr;
    @Autowired
    private RedevableService rs;
    @Autowired
    private TerrainService ts;
    @Autowired
    private TauxService tauxService;

    @Autowired
    private CategorieService cs;

    @Override
    public Taxe save(Taxe o) {
        Redevable redevable = rs.findByCin(o.getRedevable().getCin());
        Terrain terrain =  ts.findById(o.getTerrain().getId());
        Categorie categorie = cs.findById(o.getCategorie().getId());
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

        // Set the related entities
        o.setRedevable(redevable);
        o.setTerrain(terrain);
        o.setCategorie(categorie);
        o.setTaux(taux);
        return tr.save(o);
    }

    @Override
    public void update(Taxe o) {
        tr.save(o);
    }

    @Override
    public void delete(Taxe id) {
        tr.delete(id);
    }

    @Override
    public Taxe findById(long id) {
        return tr.findById(id);
    }

    @Override
    public List<Taxe> findAll() {
        return tr.findAll();
    }




}
