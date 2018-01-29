package pl.aszul.patronage;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.aszul.patronage.bootstrap.SpringBootstrap;
import pl.aszul.patronage.controllers.PersonController;
import pl.aszul.patronage.controllers.VehicleController;
import pl.aszul.patronage.services.PersonService;
import pl.aszul.patronage.services.VehicleService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
@WebAppConfiguration
public class SpringBootWebApplicationTests {

	@Test
	public void contextLoads() {
	}

}