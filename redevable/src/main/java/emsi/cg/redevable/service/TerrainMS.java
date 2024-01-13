package emsi.cg.redevable.service;

import emsi.cg.redevable.entity.Categorie;
import emsi.cg.redevable.entity.Redevable;
import emsi.cg.redevable.entity.Taux;
import emsi.cg.redevable.entity.Terrain;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name="SERVICE-TERRAIN")
public interface TerrainMS {

    @GetMapping(path = "/api/categorie/find/{id}")
    Categorie categorieById (@PathVariable("id") Long id);

    @GetMapping(path = "/api/taux/find/{id}")
    Taux tauxById (@PathVariable("id") Long id);

    @GetMapping(path = "/api/terrain/find/{id}")
    Terrain terrainById (@PathVariable("id") Long id);

    @GetMapping(path ="/terrain/redevable")
    List<Terrain> findByRedevableCin(String cin);

}
