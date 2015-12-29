package org.encrypt.method;

import java.security.MessageDigest;
import java.util.Optional;

import org.encrypt.interfaces.Encode;
import org.encrypt.util.Empty;

public abstract class EncodeSimpleAbstract implements Encode<byte[]> {	
	//metodos que utlizan clases hijas para encriptar.
	private String method = Empty.STRING;
	
	public EncodeSimpleAbstract(String method) {
		this.method = method;
	}
	
	//encripta el mensaje y codifica en base64 para darle mas seguridad.
	private byte[] encryptor(byte[] message) throws Exception{
		MessageDigest cipher = MessageDigest.getInstance(method);
		return cipher.digest(message); 
	}

	//verifica si el mensaje esta en blanco y devuelve un Optional encriptado.
	@Override
	public Optional<byte[]> encode(byte[] message) throws RuntimeException{
		try{
			return Optional.of(encryptor(message));
		}catch(Exception exception){
			throw new RuntimeException(exception);
		}
	}
}
