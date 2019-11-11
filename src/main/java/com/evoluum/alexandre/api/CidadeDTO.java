package com.evoluum.alexandre.api;

import com.evoluum.alexandre.dto.Cidade;

public class CidadeDTO {

	private final long idEstado;
	private final String siglaEstado;
	private final String regiaoNome;
	private final String nomeCidade;
	private final String nomeMesorregiao;
	private final String nomeFormatado;

	public CidadeDTO(Cidade cidade) {
		this.idEstado = cidade.getUF().getId();
		this.siglaEstado = cidade.getUF().getSigla();
		this.regiaoNome = cidade.getRegiao().getNome();
		this.nomeCidade = cidade.getNome();
		this.nomeMesorregiao = cidade.getMesorregiao().getNome();
		this.nomeFormatado = this.nomeCidade + "/" + this.siglaEstado;
	}

	public long getIdEstado() {
		return idEstado;
	}

	public String getSiglaEstado() {
		return siglaEstado;
	}

	public String getRegiaoNome() {
		return regiaoNome;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public String getNomeMesorregiao() {
		return nomeMesorregiao;
	}

	public String getNomeFormatado() {
		return nomeFormatado;
	}
}
