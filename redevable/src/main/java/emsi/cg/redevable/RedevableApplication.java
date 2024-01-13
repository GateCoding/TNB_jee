package emsi.cg.redevable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RedevableApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedevableApplication.class, args);
    }

}
