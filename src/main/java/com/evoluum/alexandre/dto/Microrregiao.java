package com.evoluum.alexandre.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Microrregiao {

	private long id;
	private String nome;
	private Mesorregiao mesorregiao;

	public Microrregiao() {
		mesorregiao = new Mesorregiao();
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

	public Mesorregiao getMesorregiao() {
		return mesorregiao;
	}

	public void setMesorregiao(Mesorregiao mesorregiao) {
		this.mesorregiao = mesorregiao;
	}

	@Override
	public String toString() {
		return "Microrregiao [id=" + id + ", nome=" + nome + "]";
	}

}
