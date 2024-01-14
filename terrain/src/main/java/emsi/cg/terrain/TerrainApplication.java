package emsi.cg.terrain;

import emsi.cg.terrain.entity.*;
import emsi.cg.terrain.service.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableRabbit
public class TerrainApplication implements CommandLineRunner {

	@Autowired
	TerrainService terrainService;
	@Autowired
	CategorieService cs;
	@Autowired
	TauxService ts;
	@Autowired
	TaxeService txs;
	@Autowired
	RedevableMS rm;

	public static void main(String[] args) {
		SpringApplication.run(TerrainApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//   categorieService.save(new Categorie("test"));

		Redevable redevable1 = rm.getRedevableByCin("EE3456789");
		Redevable redevable2 = rm.getRedevableByCin("JR9654321");
		Redevable redevable3 = rm.getRedevableByCin("NL7789123");
		if (redevable1!= null && redevable2!= null && redevable3 != null){


		// Create Categorie instances
		Categorie categorie1 = new Categorie(0,"Villa");
		Categorie categorie2 = new Categorie(0,"Apartment");
		cs.save(categorie1);
		cs.save(categorie2);

		// Create Taux instances (tax rates)
		Taux taux1 = new Taux(0.01, 2024, categorie1);
		Taux taux2 = new Taux(0.015, 2024, categorie2);
		ts.save(taux1);
		ts.save(taux2);

// For Redevable 1
		Terrain terrain1_1 = new Terrain(100.0, redevable1.getCin(), categorie1);
		Terrain terrain1_2 = new Terrain(150.0, redevable1.getCin(), categorie2);
		Terrain terrain1_3 = new Terrain(200.0, redevable1.getCin(), categorie1);
		terrainService.save(terrain1_1);
		terrainService.save(terrain1_2);
		terrainService.save(terrain1_3);

// For Redevable 2
		Terrain terrain2_1 = new Terrain(120.0, redevable2.getCin(), categorie2);
		Terrain terrain2_2 = new Terrain(180.0, redevable2.getCin(), categorie1);
		Terrain terrain2_3 = new Terrain(220.0, redevable2.getCin(), categorie2);
		terrainService.save(terrain2_1);
		terrainService.save(terrain2_2);
		terrainService.save(terrain2_3);

// For Redevable 3
		Terrain terrain3_1 = new Terrain(90.0, redevable3.getCin(), categorie1);
		Terrain terrain3_2 = new Terrain(130.0, redevable3.getCin(), categorie2);
		Terrain terrain3_3 = new Terrain(170.0, redevable3.getCin(), categorie1);
		terrainService.save(terrain3_1);
		terrainService.save(terrain3_2);
		terrainService.save(terrain3_3);

		// For Redevable 1
		Taxe taxe1_1_1 = new Taxe(false,1, taux1, terrain1_1, categorie1, redevable1.getCin());
		Taxe taxe1_1_2 = new Taxe(false,1, taux2, terrain1_1, categorie2, redevable1.getCin());
		txs.save(taxe1_1_1);
		txs.save(taxe1_1_2);

		Taxe taxe1_2_1 = new Taxe(false,1, taux1, terrain1_2, categorie1, redevable1.getCin());
		Taxe taxe1_2_2 = new Taxe(false,1, taux2, terrain1_2, categorie2, redevable1.getCin());
		txs.save(taxe1_2_1);
		txs.save(taxe1_2_2);

		Taxe taxe1_3_1 = new Taxe(false,1, taux1, terrain1_3, categorie1, redevable1.getCin());
		Taxe taxe1_3_2 = new Taxe(true,1, taux2, terrain1_3, categorie2, redevable1.getCin());
		txs.save(taxe1_3_1);
		txs.save(taxe1_3_2);

		// For Redevable 2
		Taxe taxe2_1_1 = new Taxe(false,1, taux2, terrain2_1, categorie2, redevable2.getCin());
		Taxe taxe2_1_2 = new Taxe(false,1, taux1, terrain2_1, categorie1, redevable2.getCin());
		txs.save(taxe2_1_1);
		txs.save(taxe2_1_2);

		Taxe taxe2_2_1 = new Taxe(true,1, taux2, terrain2_2, categorie2, redevable2.getCin());
		Taxe taxe2_2_2 = new Taxe(false,1, taux1, terrain2_2, categorie1, redevable2.getCin());
		txs.save(taxe2_2_1);
		txs.save(taxe2_2_2);

		Taxe taxe2_3_1 = new Taxe(true,1, taux2, terrain2_3, categorie2, redevable2.getCin());
		Taxe taxe2_3_2 = new Taxe(false,1, taux1, terrain2_3, categorie1, redevable2.getCin());
		txs.save(taxe2_3_1);
		txs.save(taxe2_3_2);

// For Redevable 3
		Taxe taxe3_1_1 = new Taxe(false,1, taux1, terrain3_1, categorie1, redevable3.getCin());
		Taxe taxe3_1_2 = new Taxe(false,1, taux2, terrain3_1, categorie2, redevable3.getCin());
		txs.save(taxe3_1_1);
		txs.save(taxe3_1_2);

		Taxe taxe3_2_1 = new Taxe(false,1, taux1, terrain3_2, categorie1, redevable3.getCin());
		Taxe taxe3_2_2 = new Taxe(false,1, taux2, terrain3_2, categorie2, redevable3.getCin());
		txs.save(taxe3_2_1);
		txs.save(taxe3_2_2);

		Taxe taxe3_3_1 = new Taxe(false,1, taux1, terrain3_3, categorie1, redevable3.getCin());
		Taxe taxe3_3_2 = new Taxe(false,1, taux2, terrain3_3, categorie2, redevable3.getCin());
		txs.save(taxe3_3_1);
		txs.save(taxe3_3_2);
		}else {
			System.out.println("=============> ERROR");
		}
	}

}
