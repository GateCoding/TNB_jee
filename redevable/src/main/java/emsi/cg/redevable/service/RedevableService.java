package emsi.cg.redevable.service;

import emsi.cg.redevable.entity.Redevable;
import emsi.cg.redevable.repository.RedevableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RedevableService {

    @Autowired
    RedevableRepository rr;
    @Autowired
    TerrainMS terrainMS;
    public Redevable save(Redevable o) {

        System.out.println("test : "+rr.save(o));
        return null;
    }

    public void update(Redevable o) {
        rr.save(o);
    }

    public void delete(Redevable id) {
        rr.delete(id);
    }

    public Redevable findByCin(String cin) {
        return rr.findByCin(cin);
    }

    public List<Redevable> findAll() {
        return rr.findAll();
    }

}
