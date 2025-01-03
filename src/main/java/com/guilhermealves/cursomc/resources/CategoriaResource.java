package com.guilhermealves.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.guilhermealves.cursomc.domain.Categoria;
import com.guilhermealves.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
    
    @Autowired
    private CategoriaService service;

    // Método para buscar uma categoria por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Categoria obj = service.buscar(id);
        return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.notFound().build();
    }

    // Método para salvar uma nova categoria
    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
        Categoria obj = service.salvar(categoria); // Salva a categoria
        return ResponseEntity.ok().body(obj); // Retorna a categoria salva
    }
}
