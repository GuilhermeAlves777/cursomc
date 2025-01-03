package com.guilhermealves.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.guilhermealves.cursomc.domain.Categoria;
import com.guilhermealves.cursomc.domain.Cidade;
import com.guilhermealves.cursomc.domain.Estado;
import com.guilhermealves.cursomc.domain.Produto;
import com.guilhermealves.repositories.CategoriaRepository;
import com.guilhermealves.repositories.CidadeRepository;
import com.guilhermealves.repositories.EstadoRepository;
import com.guilhermealves.repositories.ProdutoRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.guilhermealves.repositories")
@EntityScan(basePackages ="com.guilhermealves.cursomc.domain")

//O método CommandLineRunner permiti a execução que está dentro da classe para quando a aplicação iniciar
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	//Instanciando objetos logo após a inicialização do projeto
	@Override
	public void run(String... args) throws Exception {
		
		
		//Instâncias
		Categoria cat1 = new Categoria (null, "Informática");
		Categoria cat2 = new Categoria (null, "Escritório");
		
		Produto p1 = new Produto (null, "Computador", 2000.00);
		Produto p2 = new Produto (null, "Impressora", 800.00);
		Produto p3 = new Produto (null, "Mouse", 80.00);
		
		//Associações
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado (null, "Minas Gerais");
		Estado est2 = new Estado (null, "São Paulo");
		
		Cidade c1 = new Cidade (null, "Ubêrlandia", est1);
		Cidade c2 = new Cidade (null, "São Paulo", est2);
		Cidade c3 = new Cidade (null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
	}

}
 