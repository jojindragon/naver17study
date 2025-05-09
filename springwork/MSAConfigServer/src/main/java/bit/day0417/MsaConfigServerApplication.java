package bit.day0417;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("bit.day0417.*")
@EnableConfigServer
public class MsaConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaConfigServerApplication.class, args);
	}

}
/*
 * localhost:8010/ms1/dev => git repo에 저장된 파일명 경로 따라감
 */