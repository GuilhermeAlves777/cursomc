package com.guilhermealves.cursomc.resources;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilhermealves.cursomc.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	//Associação com um verbo do HTTP para busca de dados
	@GetMapping
	
	
	public List<Categoria> listar() {
		
		//Instância dos objetos
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");
		
		//Criação do Lista com os onjetos instanciados
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		// Verificação se o REST está funcionando
		return lista;
	}
	
}
