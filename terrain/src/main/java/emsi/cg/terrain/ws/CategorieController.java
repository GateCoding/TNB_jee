package emsi.cg.terrain.ws;

import emsi.cg.terrain.entity.Categorie;
import emsi.cg.terrain.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CategorieController {

    @Autowired
    CategorieService cs;

    @GetMapping("/categories")
    public List<Categorie> getAllCategories(){
        return cs.findAll();
    }

    @PostMapping("/categorie/save")
    public void saveCategorie(@RequestBody Categorie c){
        cs.save(c);
    }

}