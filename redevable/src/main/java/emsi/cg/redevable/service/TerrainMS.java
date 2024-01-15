package emsi.cg.redevable.service;

import emsi.cg.redevable.entity.*;
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

    @GetMapping(path = "/api/taxe/find/{id}")
    Taxe taxebyId (@PathVariable("id") Long id);

    @GetMapping(path ="/terrain/redevable/{cin}")
    List<Terrain> findByRedevableCin(@PathVariable("cin") String cin);

}
