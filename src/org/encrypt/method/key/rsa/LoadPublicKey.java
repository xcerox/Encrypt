package org.encrypt.method.key.rsa;

import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import org.encrypt.interfaces.LoadKey;
import org.encrypt.util.MethodEncode;

public class LoadPublicKey implements LoadKey<Key, byte[]> {
	
	/**
	 * Metodo implementado
	 * @see LoadKey
	 */
	@Override
	public PublicKey loadKey(byte[] origen) throws RuntimeException {
		try {
			X509EncodedKeySpec encodeKey = new X509EncodedKeySpec(origen);
			KeyFactory generator = KeyFactory.getInstance(MethodEncode.RSA);
			return generator.generatePublic(encodeKey);
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

}
