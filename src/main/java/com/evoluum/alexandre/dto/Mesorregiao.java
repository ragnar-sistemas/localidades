package com.evoluum.alexandre.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Mesorregiao {

	private long id;
	private String nome;
	private UF uf;

	public Mesorregiao() {
		uf = new UF();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UF getUF() {
		return uf;
	}

	public void setUF(UF uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "Mesorregiao [id=" + id + ", nome=" + nome + "]";
	}
}
