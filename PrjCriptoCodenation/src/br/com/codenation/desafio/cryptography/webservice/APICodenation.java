package br.com.codenation.desafio.cryptography.webservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import br.com.codenation.desafio.cryptography.model.Codenation;

public class APICodenation {
	
	private HttpURLConnection connection = null;
	
	private HttpURLConnection getUrlConnectionGet() {
		try {
			if (connection == null) {
				URL url = new URL("https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=74f9de9e977c5bf65430e34501fa969e20c7eb54");
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.setRequestProperty("Accept", "application/json");
			}
			return connection;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public Codenation get() throws Exception {
		if (getUrlConnectionGet().getResponseCode() != 200) {
			throw new RuntimeException("HTTP error code : "+ getUrlConnectionGet().getResponseCode());
		}

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getUrlConnectionGet().getInputStream()));
		return new Gson().fromJson(bufferedReader, Codenation.class);
	}
	
	public void post(Codenation value) throws Exception {
		
	}
	
}
