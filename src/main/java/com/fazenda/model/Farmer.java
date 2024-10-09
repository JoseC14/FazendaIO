package com.fazenda.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Farmer {

	@Id
	private String cpf;
	
	private String nome;
	
	private String email;

	
	@OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL)
	private List<Animal> animals;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
