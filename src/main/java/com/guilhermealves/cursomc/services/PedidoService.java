package com.guilhermealves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermealves.cursomc.domain.Pedido;
import com.guilhermealves.cursomc.services.exceptions.ObjectNotFoundException;
import com.guilhermealves.repositories.PedidoRepository;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository repo;
    
    //Operação que busca os objetos do tipo Pedido pelo id
    public Pedido buscar(Integer id) { 
    	Optional<Pedido> obj = repo.findById(id); 
    	return obj.orElseThrow(() -> new ObjectNotFoundException( 
    	"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())); 
        	
    }
    
    
    //Método para salvar uma nova Pedido no banco de dados
    public Pedido salvar(Pedido Pedido) {
        return repo.save(Pedido); // Persistindo a Pedido no banco de dados
    }
}
