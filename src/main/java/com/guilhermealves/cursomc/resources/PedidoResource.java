package com.guilhermealves.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.guilhermealves.cursomc.domain.Pedido;
import com.guilhermealves.cursomc.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
    
    @Autowired
    private PedidoService service;

    // Método para buscar uma Pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Pedido obj = service.buscar(id);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.notFound().build();
    }

    // Método para salvar uma nova Pedido
    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody Pedido Pedido) {
        Pedido obj = service.salvar(Pedido); // Salva a Pedido
        return ResponseEntity.ok().body(obj); // Retorna a Pedido salva
    }
}
