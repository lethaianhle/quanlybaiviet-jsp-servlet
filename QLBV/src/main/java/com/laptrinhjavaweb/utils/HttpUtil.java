package com.laptrinhjavaweb.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	
	private String value;

	public HttpUtil(String value) {
		this.value = value;
	}

	public static HttpUtil of(BufferedReader bufferedReader) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		String line = bufferedReader.readLine();
		while(line != null) {
			stringBuilder.append(line);
			line = bufferedReader.readLine();
		}
		return new HttpUtil(stringBuilder.toString());
	}
	
	public <T> T toModel(Class<T> tClass) {	
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
