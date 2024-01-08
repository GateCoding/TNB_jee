package com.example.tnb;

import com.example.tnb.entity.Categorie;
import com.example.tnb.entity.Redevable;
import com.example.tnb.service.CategorieService;
import com.example.tnb.service.RedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TnbApplication implements CommandLineRunner {
    @Autowired
    CategorieService categorieService ;
    @Autowired
    RedevableService redevableService;
    public static void main(String[] args) {
        SpringApplication.run(TnbApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        categorieService.save(new Categorie("test"));

        Redevable r = new Redevable("E4546", "client1","test1");
        Redevable r1 = new Redevable("N56475", "client2","test2");
        Redevable r2 = new Redevable("E785554", "client3","test3");

        redevableService.save(r);
        redevableService.save(r1);
        redevableService.save(r2);

    }
}
