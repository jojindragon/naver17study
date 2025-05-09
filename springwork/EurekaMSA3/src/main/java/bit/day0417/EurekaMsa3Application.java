package bit.day0417;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("bit.day0417.*")
@EnableDiscoveryClient
public class EurekaMsa3Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaMsa3Application.class, args);
	}

}
