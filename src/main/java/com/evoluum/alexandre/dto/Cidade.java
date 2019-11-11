package com.evoluum.alexandre.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cidade {

	private long id;
	private String nome;
	private Microrregiao microrregiao;

	public Cidade() {
		microrregiao = new Microrregiao();
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

	public Microrregiao getMicrorregiao() {
		return microrregiao;
	}

	public void setMicrorregiao(Microrregiao microrregiao) {
		this.microrregiao = microrregiao;
	}

	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + "]";
	}

	public Mesorregiao getMesorregiao() {
		return microrregiao.getMesorregiao();
	}

	public UF getUF() {
		return getMesorregiao().getUF();
	}

	public Regiao getRegiao() {
		return getUF().getRegiao();
	}

}
