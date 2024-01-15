package emsi.cg.terrain.repository;

import emsi.cg.terrain.entity.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeRepository extends JpaRepository<Taxe, Integer> {
}
