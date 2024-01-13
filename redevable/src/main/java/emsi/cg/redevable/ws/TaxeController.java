package emsi.cg.redevable.ws;

import com.example.tnb.entity.Taxe;
import com.example.tnb.service.TaxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("api")
public class TaxeController {

    @Autowired
    TaxeService ts;

    @GetMapping("/taxe")
    public List<Taxe> getAllTaxe(){
        return ts.findAll();
    }

    @PostMapping("/taxe/save")
    public void saveTaxe(@RequestBody Taxe t){
        ts.save(t);
    }

}
