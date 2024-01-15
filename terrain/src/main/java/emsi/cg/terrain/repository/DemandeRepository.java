package emsi.cg.terrain.repository;

import emsi.cg.terrain.entity.Categorie;
import emsi.cg.terrain.entity.Taxe;
import emsi.cg.terrain.rmq.DemandePaiementProducer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeRepository extends JpaRepository<DemandePaiementProducer, Integer> {
    void save(DemandeRepository d);
    DemandePaiementProducer findById(long id);
}
