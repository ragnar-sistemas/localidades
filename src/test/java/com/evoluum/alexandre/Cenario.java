package com.evoluum.alexandre;

import java.util.ArrayList;
import java.util.List;

import com.evoluum.alexandre.api.CidadeDTO;
import com.evoluum.alexandre.dto.Cidade;
import com.evoluum.alexandre.dto.Mesorregiao;
import com.evoluum.alexandre.dto.Microrregiao;
import com.evoluum.alexandre.dto.Regiao;
import com.evoluum.alexandre.dto.UF;

public final class Cenario {

	private Cenario() {
	}

	public static List<CidadeDTO> getAll() {
		List<CidadeDTO> dtos = new ArrayList<>();
		for (Cidade cidade : cidades()) {
			dtos.add(new CidadeDTO(cidade));
		}
		return dtos;
	}

	public static List<Cidade> cidades() {
		List<Cidade> cidades = new ArrayList<>();
		cidades.add(cidade());
		return cidades;
	}

	public static Cidade cidade() {
		Cidade cidade = new Cidade();
		cidade.setId(1);
		cidade.setNome("São José");
		cidade.setMicrorregiao(microrregiao());
		return cidade;
	}

	public static Microrregiao microrregiao() {
		Microrregiao microrregiao = new Microrregiao();
		microrregiao.setId(1);
		microrregiao.setNome("Florianópolis");
		microrregiao.setMesorregiao(mesorregiao());
		return microrregiao;
	}

	public static Mesorregiao mesorregiao() {
		Mesorregiao mesorregiao = new Mesorregiao();
		mesorregiao.setId(1);
		mesorregiao.setUF(estado());
		mesorregiao.setNome("Grande Florianópolis");
		return mesorregiao;
	}

	public static UF estado() {
		UF estado = new UF();
		estado.setId(1);
		estado.setNome("Santa Catarina");
		estado.setSigla("SC");
		estado.setRegiao(regiao());
		return estado;
	}

	public static Regiao regiao() {
		Regiao regiao = new Regiao();
		regiao.setId(1);
		regiao.setNome("Sul");
		regiao.setSigla("S");
		return regiao;
	}
}
