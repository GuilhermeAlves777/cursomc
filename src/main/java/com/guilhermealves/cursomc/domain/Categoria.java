package com.guilhermealves.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

//Serializable serve para a conversão dos dados para Bytes, para os objetos poderem ser gravados em arquivos e trafegar na rede
public class Categoria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Declarando os atributos
	private Integer id;
	private String nome;
	
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
	
	
	
}
