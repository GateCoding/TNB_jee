package com.example.tnb;

import com.example.tnb.entity.Categorie;
import com.example.tnb.entity.Redevable;
import com.example.tnb.service.CategorieService;
import com.example.tnb.service.RedevableService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TnbApplication {

    public static void main(String[] args) {
        SpringApplication.run(TnbApplication.class, args);
//        System.out.println("helloooooo");
//        Categorie c = new Categorie("test");
//        CategorieService cs = new CategorieService();
//        cs.save(c);
//        Redevable r = new Redevable("E4546", "client1","test1");
//        Redevable r1 = new Redevable("N56475", "client2","test2");
//        Redevable r2 = new Redevable("E785554", "client3","test3");
//        RedevableService rs = new RedevableService();
////        System.out.println(r);
//        rs.save(r);
//        rs.save(r1);
//        rs.save(r2);
    }

}
