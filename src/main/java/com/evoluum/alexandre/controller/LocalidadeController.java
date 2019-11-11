package com.evoluum.alexandre.controller;

import static com.evoluum.alexandre.util.SourceStreamTranslator.toInputStreamResource;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evoluum.alexandre.api.CidadeDTO;
import com.evoluum.alexandre.service.LocalidadeService;
import com.evoluum.alexandre.util.DownloadFileHeaderBuilder;

@RestController
public class LocalidadeController {

	public static final String LOCALIDADES = "/localidades";
	public static final String ESTADOS = "/estados";
	public static final String DOWNLOAD = "/download";
	public static final String CIDADES_NOME_CIDADE = "/cidades/{nmCidade}";

	@Autowired
	private LocalidadeService service;

	@RequestMapping(value = LOCALIDADES + ESTADOS, method = GET)
	public List<CidadeDTO> getAll() {
		return service.getAllCidades();
	}

	@RequestMapping(value = LOCALIDADES + DOWNLOAD, method = GET)
	public ResponseEntity<InputStreamResource> download() throws IOException {
		String content = service.getCSV();
		HttpHeaders headers = new DownloadFileHeaderBuilder().withFilename("cidades.cvs").withLength(content.getBytes().length).build();
		return new ResponseEntity<InputStreamResource>(toInputStreamResource(content.getBytes()), headers, OK);
	}

	@RequestMapping(value = LOCALIDADES + CIDADES_NOME_CIDADE, method = GET)
	public List<Long> getIdCidade(@PathVariable(value = "nmCidade") String nmCidade) {
		return service.getIdCidadeByName(nmCidade);
	}

}
