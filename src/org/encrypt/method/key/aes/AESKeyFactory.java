package org.encrypt.method.key.aes;

import java.security.Key;

import org.encrypt.interfaces.KeyGenerator;
import org.encrypt.util.MethodEncode;

public class AESKeyFactory implements KeyGenerator<Key> {
	private int keyZise = 128;
	
	/**
	 * Metodo para asignar tamaño de la llave.
	 * @param keyZise tamaño de la llave.
	 */
	public void setKeyZise(int keyZise){
		this.keyZise = keyZise;
	}
	
	/**
	 * Metodo implementado
	 * @see KeyGenerator
	 */
	@Override
	public Key create() throws RuntimeException {
		try{
			javax.crypto.KeyGenerator keyGenerator =  javax.crypto.KeyGenerator.getInstance(MethodEncode.AES);
			keyGenerator.init(keyZise);
			return keyGenerator.generateKey();
		}catch(Exception exception){
			throw new RuntimeException(exception);
		}
	}
	
}
