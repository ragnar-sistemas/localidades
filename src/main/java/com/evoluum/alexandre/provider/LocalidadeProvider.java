package com.evoluum.alexandre.provider;

import static java.util.Arrays.asList;

import java.util.List;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.evoluum.alexandre.dto.Cidade;

public class LocalidadeProvider {

	private static final String HTTPS = "https";
	private static final String HOST = "servicodados.ibge.gov.br";
	private static final String PATH = "api/v1/localidades/municipios";

	public List<Cidade> getCidades() {
		return asList(getRestTemplate().getForEntity(getUriComponents().toUriString(), Cidade[].class).getBody());
	}

	private RestTemplate getRestTemplate() {
		return new RestTemplate(new HttpComponentsClientHttpRequestFactory(HttpClientBuilder.create().build()));
	}

	private UriComponents getUriComponents() {
		return UriComponentsBuilder.newInstance().scheme(HTTPS).host(HOST).path(PATH).build();
	}
}
