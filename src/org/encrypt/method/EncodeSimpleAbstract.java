package org.encrypt.method;

/**
 * Clase de encriptacion basica.
 * @author j.reyes
 * @version 1.0
 */
import java.security.MessageDigest;
import java.util.Optional;

import org.encrypt.interfaces.Encode;
import org.encrypt.util.Empty;

public abstract class EncodeSimpleAbstract implements Encode<byte[]> {	
	private String method = Empty.STRING;
	
	/**
	 * Contructor de la clase abstracta para definir el tipo de encriptacion.
	 * @param method parametro para asignar tipo de encriptacion desde las clases hijas.
	 */
	public EncodeSimpleAbstract(String method) {
		this.method = method;
	}
	
	/**
	 * Metodo para encriptar base.
	 * @param message parametro que contiene el mensaje a encriptar
	 * @return arreglo bytes del mensaje encriptado.
	 * @throws Exception
	 */
	private byte[] encryptor(byte[] message) throws Exception{
		MessageDigest cipher = MessageDigest.getInstance(method);
		return cipher.digest(message); 
	}

	/**
	 * Metodo de encriptacion 
	 * @param message parametro que contiene el mensaje a encriptar.
	 * @return Optional con el arreglo bytes del mensaje encriptado.
	 * @throws RuntimeException
	 */
	@Override
	public Optional<byte[]> encode(byte[] message) throws RuntimeException{
		try{
			return Optional.of(encryptor(message));
		}catch(Exception exception){
			throw new RuntimeException(exception);
		}
	}
}
