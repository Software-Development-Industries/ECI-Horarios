package edu.eci.ecihorarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.ecihorarios"})
public class EciHorariosApp {

	public static void main(String[] args) {
		SpringApplication.run(EciHorariosApp.class, args);
	}

}
