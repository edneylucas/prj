package br.com.codenation.desafio.cryptography.cripto.securehashalgorithm;

import org.apache.commons.codec.digest.DigestUtils;

public class SecureHashAlgorithm {

	public static String criptar(String message) {
		return DigestUtils.shaHex(message);
	}
}
