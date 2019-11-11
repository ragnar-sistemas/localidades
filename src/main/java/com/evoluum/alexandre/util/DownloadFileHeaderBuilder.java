package com.evoluum.alexandre.util;

import java.net.FileNameMap;
import java.net.URLConnection;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class DownloadFileHeaderBuilder {

	private static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
	private Integer length;
	private String filename;

	public DownloadFileHeaderBuilder withLength(Integer length) {
		this.length = length;
		return this;
	}

	public DownloadFileHeaderBuilder withFilename(String filename) {
		this.filename = filename;
		return this;
	}

	public HttpHeaders build() {
		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		String mediaType = fileNameMap.getContentTypeFor(filename);
		HttpHeaders headers = new HttpHeaders();
		MediaType parseMediaType = MediaType.parseMediaType(mediaType == null ? APPLICATION_OCTET_STREAM : mediaType);
		headers.setContentType(parseMediaType);
		headers.setContentLength(length);
		headers.add("Access-Control-Allow-Headers", "Content-Type");
		headers.add("Content-Disposition", "filename=\"" + filename + "\"");
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		return headers;
	}

}
