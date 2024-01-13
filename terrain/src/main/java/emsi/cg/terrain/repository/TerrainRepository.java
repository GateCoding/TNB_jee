package emsi.cg.terrain.repository;

import com.example.tnb.entity.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Integer> {
    Terrain findById(long id);
    List<Terrain> findByRedevableCin(String cin);

}
