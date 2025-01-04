package com.guilhermealves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermealves.cursomc.domain.Categoria;
import com.guilhermealves.cursomc.services.exceptions.ObjectNotFoundException;
import com.guilhermealves.repositories.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repo;
    
    //Operação que busca os objetos do tipo categoria pelo id
    public Categoria buscar(Integer id) { 
    	Optional<Categoria> obj = repo.findById(id); 
    	return obj.orElseThrow(() -> new ObjectNotFoundException( 
    	"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())); 
        	
    }
    
    
    //Método para salvar uma nova categoria no banco de dados
    public Categoria salvar(Categoria categoria) {
        return repo.save(categoria); // Persistindo a categoria no banco de dados
    }
}
