package br.com.codenation.desafio.cryptography;

import java.io.BufferedWriter;
import java.io.FileWriter;

import com.google.gson.Gson;

import br.com.codenation.desafio.cryptography.cripto.juliocesar.CriptoJulioCesar;
import br.com.codenation.desafio.cryptography.cripto.securehashalgorithm.SecureHashAlgorithm;
import br.com.codenation.desafio.cryptography.model.Codenation;
import br.com.codenation.desafio.cryptography.webservice.APICodenation;

public class Cryptography {

	public static void main(String[] args) {
		try {
			
			APICodenation api = new APICodenation();
			
			Codenation codenation = api.get();
			String decifrado = CriptoJulioCesar.decriptar(codenation.getNumero_casas(), codenation.getCifrado());
			
			codenation.setDecifrado(decifrado);
			codenation.setResumo_criptografico(SecureHashAlgorithm.criptar(decifrado));
			
			// Salvar um arquivo
			String json = new Gson().toJson(codenation);
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Temp\\answer.json"));
			bufferedWriter.write(json);
			
			bufferedWriter.close();
			
			
			
			System.out.println("Aqui");
			
			
			
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}

}
