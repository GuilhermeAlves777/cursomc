package com.guilhermealves.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.guilhermealves.cursomc.domain.Cliente;
import com.guilhermealves.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
    
    @Autowired
    private ClienteService service;

    // Método para buscar uma Cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Cliente obj = service.buscar(id);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.notFound().build();
    }

    // Método para salvar uma nova Cliente
    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente Cliente) {
        Cliente obj = service.salvar(Cliente); // Salva a Cliente
        return ResponseEntity.ok().body(obj); // Retorna a Cliente salva
    }
}
