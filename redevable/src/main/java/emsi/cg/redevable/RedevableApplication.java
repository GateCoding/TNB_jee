package emsi.cg.redevable;

import emsi.cg.redevable.entity.Redevable;
import emsi.cg.redevable.service.RedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RedevableApplication implements CommandLineRunner {
//    @Autowired
//    CategorieService categorieService ;
    @Autowired
RedevableService redevableService;
    public static void main(String[] args) {
        SpringApplication.run(RedevableApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
     //   categorieService.save(new Categorie("test"));

        Redevable r = new Redevable("E4546", "client1","test1");
        Redevable r1 = new Redevable("N56475", "client2","test2");
        Redevable r2 = new Redevable("E785554", "client3","test3");

        redevableService.save(r);
        redevableService.save(r1);
        redevableService.save(r2);

    }
//    public static void main(String[] args) {
//        SpringApplication.run(RedevableApplication.class, args);
//    }

}
