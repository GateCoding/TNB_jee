package emsi.cg.terrain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TerrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerrainApplication.class, args);
	}


}
