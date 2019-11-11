package com.evoluum.alexandre.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.InputStreamResource;

public class SourceStreamTranslator {

	private SourceStreamTranslator() {
	}

	public static InputStreamResource toInputStreamResource(byte[] source) throws IOException {
		InputStream inputStream = new ByteArrayInputStream(source);
		try {
			return new InputStreamResource(inputStream);
		} finally {
			inputStream.close();
		}
	}

}
