package com.guilhermealves.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

//Indicação que a classe vai ser uma entidade do JPA  
@Entity
//Serializable serve para a conversão dos dados para Bytes, para os objetos poderem ser gravados em arquivos e trafegar na rede
public class Categoria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Definição da definição automática dos IDs
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	
	//Declarando os atributos
	private Integer id;
	private String nome;
	
	@JsonManagedReference
	@ManyToMany(mappedBy = "categorias", fetch = FetchType.EAGER)
	private List<Produto> produtos = new ArrayList<Produto>();
	
	//Declarando a classe construtora (para a instância de objetos)
	public Categoria() {
		
	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//hashcode e equals: Para que o objetos dos aributos sejam comparados pelo seu valor
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
}
