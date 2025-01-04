package com.guilhermealves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.guilhermealves.cursomc.domain.Cidade;

//Esta classe poderá fazer ações de banco de dados (Criar, alterar, excluir) em todos os objetos do tipo categoria
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
