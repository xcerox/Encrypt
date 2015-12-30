package org.encrypt.method.key.rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

import org.encrypt.interfaces.KeyGenerator;
import org.encrypt.util.MethodEncode;

public class RSAKeyFactory implements KeyGenerator<KeyPair> {
	private int keyZise = 1024;
	
	/**
	 * Metodo para asignar tamaño de la llave
	 * @param keyZise tamaño de la llave
	 */
	public void setKeyZise(int keyZise){
		this.keyZise =  keyZise;
	}
	
	/**
	 * Metodo implementado
	 * @see KeyGenerator
	 */
	@Override
	public KeyPair create() throws RuntimeException {
		try{
			KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance(MethodEncode.RSA);
			keyGenerator.initialize(keyZise, new SecureRandom());
			KeyPair keys = keyGenerator.generateKeyPair();
			return  keys;
		}catch(Exception exception){
			throw new RuntimeException(exception);
		}
	}

}
