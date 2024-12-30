package com.guilhermealves.cursomc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages ="com.guilhermealves.cursomc.domain")
public class CursomcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

}
 