package com.evoluum.alexandre.controller;

import static com.evoluum.alexandre.controller.LocalidadeController.ESTADOS;
import static com.evoluum.alexandre.controller.LocalidadeController.LOCALIDADES;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.evoluum.alexandre.Cenario;

@RunWith(SpringRunner.class)
@WebMvcTest(LocalidadeController.class)
public class LocalidadeControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private LocalidadeController controller;

	@Test
	public void getAll() throws Exception {
		when(controller.getAll()).thenReturn(Cenario.getAll());
		mvc.perform(get(LOCALIDADES + ESTADOS)
				.contentType(APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[0].idEstado", equalTo(1)))
		.andExpect(jsonPath("$[0].siglaEstado", equalTo("SC")))
		.andExpect(jsonPath("$[0].regiaoNome", equalTo("Sul")))
		.andExpect(jsonPath("$[0].nomeCidade", equalTo("São José")))
		.andExpect(jsonPath("$[0].nomeMesorregiao", equalTo("Grande Florianópolis")))
		.andExpect(jsonPath("$[0].nomeFormatado", equalTo("São José/SC")));
	}
	
}
