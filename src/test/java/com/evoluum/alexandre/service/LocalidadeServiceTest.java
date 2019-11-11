package com.evoluum.alexandre.service;

import static com.evoluum.alexandre.Cenario.cidades;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.evoluum.alexandre.provider.LocalidadeProvider;
import com.google.gson.Gson;

@RunWith(MockitoJUnitRunner.class)
public class LocalidadeServiceTest {

	private static final String JSON = "[{\"idEstado\":1,\"siglaEstado\":\"SC\",\"regiaoNome\":\"Sul\",\"nomeCidade\":\"São José\",\"nomeMesorregiao\":\"Grande Florianópolis\",\"nomeFormatado\":\"São José/SC\"}]";
	private static final String CSV = "idEstado;siglaEstado;regiaoNome;nomeCidade;nomeMesorregiao;nomeFormatado\r\n1;SC;Sul;São José;Grande Florianópolis;São José/SC\r\n";

	@Mock
	private LocalidadeProvider provider;
	private LocalidadeService service;

	@Before
	public void antes_teste() {
		service = new LocalidadeService(provider);
	}

	@Test
	public void nao_pode_ser_nulo() {
		assertNotNull("Não deveria ser nulo", service);
	}

	@Test
	public void testa_json() {
		when(provider.getCidades()).thenReturn(cidades());
		String jsonEstados = new Gson().toJson(service.getAllCidades());
		assertNotNull("Não deveria ser nulo", jsonEstados);
		assertEquals("Não esta correto o json", JSON, jsonEstados);
	}

	@Test
	public void testa_csv() {
		when(provider.getCidades()).thenReturn(cidades());
		String csv = service.getCSV();
		assertNotNull("Não deveria ser nulo", csv);
		assertEquals("Não esta correto o json", CSV, csv);
	}

}
