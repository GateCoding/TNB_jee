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

        Redevable redevable1 = new Redevable("John", "Aimrane", "EE3456789");
        Redevable redevable2 = new Redevable("Jane", "Meryem", "JR9654321");
        Redevable redevable3 = new Redevable("Bob", "Yahya", "NL7789123");

        redevableService.save(redevable1);
        redevableService.save(redevable2);
        redevableService.save(redevable3);

    }
//    public static void main(String[] args) {
//        SpringApplication.run(RedevableApplication.class, args);
//    }

}
