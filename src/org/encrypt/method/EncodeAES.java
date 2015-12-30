package org.encrypt.method;

/**
 * Clase apra encriptacion sincrona con AES
 * @author j.reyes
 * @version 1.0
 */

import java.security.Key;
import java.util.Optional;

import javax.crypto.Cipher;

import org.encrypt.interfaces.Decode;
import org.encrypt.interfaces.Encode;

public class EncodeAES implements Encode<byte[]>, Decode<byte[]>{
	private final String algorithm = "AES/ECB/PKCS5Padding";
	private Key key;
	
	/**
	 * Metodo que se encarga de asignar la llave que se usara para cifrar y descifrar.
	 * @param key Llave para cifrar y descifrar.
	 */
	public void setKey(Key key){
		this.key = key;
	}
	
	/**
	 * Metodo para cifrar. 
	 * @param message Arreglo de bytes del mensaje a cifrar.
	 * @return Arreglo de bytes del mensaje cifrado.
	 * @throws Exception
	 */
	private byte[] encrypt(byte[] message) throws Exception{
		Cipher encryptor = Cipher.getInstance(algorithm);
		encryptor.init(Cipher.ENCRYPT_MODE, key);
		return encryptor.doFinal(message);
	}
	
	/**
	 * Metodo para descifrar.
	 * @param message Arreglo de bytes del mensaje cifrado.
	 * @return Arreglo de bytes del mensaje descifrado.
	 * @throws Exception
	 */
	private byte[] descrypt(byte[] message) throws Exception{
		Cipher descyptor = Cipher.getInstance(algorithm);
		descyptor.init(Cipher.DECRYPT_MODE, key);
		return descyptor.doFinal(message);
	}
	
	/**
	 * Metodo implementado.
	 * @see Decode
	 */
	@Override
	public Optional<byte[]> decode(byte[] message) throws RuntimeException {
		try{
			return Optional.of(descrypt(message));
		}catch(Exception exception){
			throw new RuntimeException(exception);
		}
	}

	/**
	 * Metodo implementado.
	 * @see Encode 
	 */
	@Override
	public Optional<byte[]> encode(byte[] message) throws RuntimeException {
		try {
			return Optional.of(encrypt(message));
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}
	
}
