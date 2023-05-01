package edu.mario.depaul.Hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.ws.rs.core.Application;

//port adjustment is under resources in the application properties.

@SpringBootApplication()
public class HelloApplication extends Application {


	public static void main(String[] args) {

		SpringApplication.run(HelloApplication.class, args);

	}

}
//ignore: scanBasePackages={"edu.mario.depaul.Resource","edu.mario.depaul.Hello"}
//