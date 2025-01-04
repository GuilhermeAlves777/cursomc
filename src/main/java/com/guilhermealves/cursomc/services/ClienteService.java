package com.guilhermealves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermealves.cursomc.domain.Cliente;
import com.guilhermealves.cursomc.services.exceptions.ObjectNotFoundException;
import com.guilhermealves.repositories.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repo;
    
    //Operação que busca os objetos do tipo Cliente pelo id
    public Cliente buscar(Integer id) { 
    	Optional<Cliente> obj = repo.findById(id); 
    	return obj.orElseThrow(() -> new ObjectNotFoundException( 
    	"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())); 
  
        	
    }
    
    
    //Método para salvar uma nova Cliente no banco de dados
    public Cliente salvar(Cliente Cliente) {
        return repo.save(Cliente); // Persistindo a Cliente no banco de dados
    }
}
