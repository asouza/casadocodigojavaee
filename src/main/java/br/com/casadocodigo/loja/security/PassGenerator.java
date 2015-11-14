package br.com.casadocodigo.loja.security;

import org.jboss.security.Base64Encoder;

public class PassGenerator {

	public static void main(String[] args) throws Exception {
		System.out.println(PassGenerator.generate("123456"));
	}
	
	public static String generate(String rawPassword){
		try {
			byte[] hash = java.security.MessageDigest.getInstance("SHA-256").digest(rawPassword.getBytes());
			return Base64Encoder.encode(hash);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
