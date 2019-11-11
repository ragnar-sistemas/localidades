package com.evoluum.alexandre.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.evoluum.alexandre.api.CidadeDTO;
import com.evoluum.alexandre.dto.Cidade;
import com.evoluum.alexandre.provider.LocalidadeProvider;

@Service
public class LocalidadeService {

	private static final String NOVA_LINHA = "\r\n";
	private static final String DELIMITADOR = ";";
	private LocalidadeProvider provider;

	public LocalidadeService() {
		this(new LocalidadeProvider());
	}

	public LocalidadeService(LocalidadeProvider provider) {
		this.provider = provider;
	}

	public List<CidadeDTO> getAllCidades() {
		List<CidadeDTO> dtos = new ArrayList<>();
		for (Cidade cidade : provider.getCidades()) {
			dtos.add(new CidadeDTO(cidade));
		}
		return dtos;
	}

	public String getCSV() {
		StringBuilder csv = new StringBuilder();
		csv.append("idEstado").append(DELIMITADOR).append("siglaEstado").append(DELIMITADOR).append("regiaoNome").append(DELIMITADOR);
		csv.append("nomeCidade").append(DELIMITADOR).append("nomeMesorregiao").append(DELIMITADOR).append("nomeFormatado").append(NOVA_LINHA);;
		for(CidadeDTO dto : getAllCidades()) {
			csv.append(dto.getIdEstado()).append(DELIMITADOR);
			csv.append(dto.getSiglaEstado()).append(DELIMITADOR);
			csv.append(dto.getRegiaoNome()).append(DELIMITADOR);
			csv.append(dto.getNomeCidade()).append(DELIMITADOR);
			csv.append(dto.getNomeMesorregiao()).append(DELIMITADOR);
			csv.append(dto.getNomeFormatado()).append(NOVA_LINHA);
		}
		return csv.toString();
	}

	public List<Long> getIdCidadeByName(String nmCidade) {
		List<Long> ids = new ArrayList<>();
		for (Cidade cidade : provider.getCidades()) {
			if (cidade.getNome().equalsIgnoreCase(nmCidade)) {
				ids.add(cidade.getId());
			}
		}
		return ids;
	}

}
