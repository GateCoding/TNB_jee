package emsi.cg.terrain.service;

import emsi.cg.terrain.entity.Redevable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="SERVICE-REDEVABLE")
public interface RedevableMS {

    @GetMapping(path ="/api/redevable/find/{cin}")
    Redevable getRedevableByCin(@PathVariable("cin") String cin);

}