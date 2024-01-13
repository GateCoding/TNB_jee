package emsi.cg.redevable.repository;

import emsi.cg.redevable.entity.Taxe;
import emsi.cg.redevable.entity.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxeRepository extends JpaRepository<Taxe, Integer> {
    Taxe findById(long id);
    List<Taxe> findByTerrain(Terrain t);
}
