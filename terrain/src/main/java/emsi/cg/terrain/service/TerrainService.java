package emsi.cg.terrain.service;

import emsi.cg.terrain.entity.Terrain;
import emsi.cg.terrain.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TerrainService {

    @Autowired
    private TerrainRepository tr;
    @Autowired
    RedevableMS redevableMS;

    public Terrain save(Terrain o) {
        return tr.save(o);
    }

    public void update(Terrain o) {
        tr.save(o);
    }

    public void delete(Terrain id) {
        tr.delete(id);
    }

    public Terrain findById(long id) {
        return tr.findById(id);
    }

    public List<Terrain> findAll() {
        return tr.findAll();
    }

    public List<Terrain> findByRedevableCin(String cin){
        return tr.findByRedevablecin(redevableMS.getRedevableByCin(cin).getCin());
    }
}