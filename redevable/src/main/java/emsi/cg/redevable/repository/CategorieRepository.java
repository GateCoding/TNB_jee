package emsi.cg.redevable.repository;


import emsi.cg.redevable.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
    Categorie findById(long id);
}
