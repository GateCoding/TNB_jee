package emsi.cg.redevable.ws;

import emsi.cg.redevable.entity.Redevable;
import emsi.cg.redevable.service.RedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/redevable")
public class RedevableController {
    @Autowired
    RedevableService rc;

    @PostMapping("/save")
    public void saveRedevable(@RequestBody Redevable redevable){
        rc.save(redevable);
    }

    @PostMapping("/delete/{id}")
    public void saveRedevable(@RequestBody Redevable redevable){
        rc.delete(redevable);
    }

    @GetMapping("/all")
    public List<Redevable> getAllRedevables(){
        return rc.findAll();
    }

    @GetMapping("/find/{cin}")
    public Redevable getRedevableByCin(@PathVariable("cin") String cin) {
        return this.rc.findByCin(cin);
    }

}
