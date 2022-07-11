package cl.mingeso.Horarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HorariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(HorariosApplication.class, args);
	}

}
