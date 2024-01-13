package emsi.cg.redevable.ws;

import emsi.cg.redevable.entity.Redevable;
import emsi.cg.redevable.service.RedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class RedevableController {
    @Autowired
    RedevableService rc;

    @PostMapping("/redevable/save")
    public void saveRedevable(@RequestBody Redevable redevable){
        rc.save(redevable);
    }

    @GetMapping("/redevables")
    public List<Redevable> getAllRedevables(){
        return rc.findAll();
    }

    @GetMapping("/redevable/{cin}")
    public Redevable getRedevableByCin(@PathVariable("cin") String cin) {
        return this.rc.findByCin(cin);
    }

}
