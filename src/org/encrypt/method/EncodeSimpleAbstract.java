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
	 * @param method Parametro para asignar tipo de encriptacion desde las clases hijas.
	 */
	public EncodeSimpleAbstract(String method) {
		this.method = method;
	}
	
	/**
	 * Metodo para cifrar base.
	 * @param message Arreglo de bytes del mensaje a cifrar.
	 * @return Arreglo de bytes del mensaje cifrado.
	 * @throws Exception
	 */
	private byte[] encryptor(byte[] message) throws Exception{
		MessageDigest cipher = MessageDigest.getInstance(method);
		return cipher.digest(message); 
	}

	/**
	 * Metodo implementado.
	 * @see Encode
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
