package com.guilhermealves.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.guilhermealves.cursomc.domain.Categoria;
import com.guilhermealves.repositories.CategoriaRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.guilhermealves.repositories")
@EntityScan(basePackages ="com.guilhermealves.cursomc.domain")

//O método CommandLineRunner permiti a execução que está dentro da classe para quando a aplicação iniciar
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	//Instanciando objetos logo após a inicialização do projeto
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria (null, "Informática");
		Categoria cat2 = new Categoria (null, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		
	}

}
 