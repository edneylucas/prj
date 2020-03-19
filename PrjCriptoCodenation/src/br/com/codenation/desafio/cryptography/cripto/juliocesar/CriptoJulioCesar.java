package br.com.codenation.desafio.cryptography.cripto.juliocesar;

public class CriptoJulioCesar {
	
	private static final int QTD_CARACTERES_ALFABETICO = 26;
	private static final int ACSII_DEC_LETRA_A = 97;
	
	public static String decriptar(Integer chave, String textoCifrado) {
		StringBuilder texto = new StringBuilder();
		
		for (int i=0; i < textoCifrado.length(); i++) {
			char letraCifrada = textoCifrado.toLowerCase().charAt(i);
			if (Character.isLetter(letraCifrada)) {
				texto.append((char) (Math.floorMod((letraCifrada - ACSII_DEC_LETRA_A) - chave, QTD_CARACTERES_ALFABETICO) + ACSII_DEC_LETRA_A));
			} else {
				texto.append(letraCifrada);
			}
		}  
		return texto.toString();
	}
}
