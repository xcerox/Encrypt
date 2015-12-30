package org.encrypt.method;

/**
 * Clase para encriptar Asimetrico con RSA 
 * @author j.reyes
 * @version 1.0
 */

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Optional;

import javax.crypto.Cipher;

import org.encrypt.interfaces.Decode;
import org.encrypt.interfaces.Encode;

public class EncodeRSA implements Encode<byte[]>, Decode<byte[]>{
	private final String algorithm = "RSA/ECB/PKCS1Padding";
	private PrivateKey privateKey;
	private PublicKey publicKey;

	/**
	 * Metodo para asinar llave para descifrar.
	 * @param privateKey llave para descifrar.
	 */
	public void setKeyDecrypt(PrivateKey privateKey){
		this.privateKey = privateKey;
	}
	
	/**
	 * Metodo para asignar llave para cifrar.
	 * @param publicKey llave para cifrar.
	 */
	public void setKeyEncrypt(PublicKey publicKey){
		this.publicKey = publicKey;
	}
	
	/**
	 * Metodo para descifrar.
	 * @param message Arreglo de bytes del mensaje a descifrar.
	 * @return Arreglo de bytes del mensaje descifrado.
	 * @throws Exception
	 */
	private byte[] decryptor(byte[] message) throws Exception {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return cipher.doFinal(message);
	}

	/**
	 * Metodo para cifrar.
	 * @param message Arreglo de bytes del mensaje a cifrar.
	 * @return Arreglo de bytes del mensaje cifrado.
	 * @throws Exception
	 */
	private byte[] encryptor(byte[] message) throws Exception {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, publicKey, new SecureRandom());
		return cipher.doFinal(message);
	}

	/**
	 * Metodo implementado.
	 * @see Encode
	 */
	@Override
	public Optional<byte[]> encode(byte[] message) throws RuntimeException {
		try{
			return Optional.of(encryptor(message));
		}catch(Exception exception){
			throw new RuntimeException(exception);
		}
	}

	/**
	 * Metodo implementado.
	 * @see Decode
	 */
	@Override
	public Optional<byte[]> decode(byte[] message) throws RuntimeException {
		try{
			return Optional.of(decryptor(message));
		}catch(Exception exception){
			throw new RuntimeException(exception);
		}
	}
}
