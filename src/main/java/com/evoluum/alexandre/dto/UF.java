package com.evoluum.alexandre.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UF implements Serializable {

	private static final long serialVersionUID = -8249767369837591346L;

	private long id;
	private String nome;
	private String sigla;
	private Regiao regiao;

	public UF() {
		regiao = new Regiao();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	@Override
	public String toString() {
		return "UF [id=" + id + ", sigla=" + sigla + ", nome=" + nome + "]";
	}
}
