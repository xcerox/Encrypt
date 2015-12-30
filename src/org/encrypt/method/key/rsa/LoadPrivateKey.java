package org.encrypt.method.key.rsa;

import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

import org.encrypt.interfaces.LoadKey;
import org.encrypt.util.MethodEncode;

public class LoadPrivateKey implements LoadKey<Key, byte[]> {

	/**
	 * Metodo implementado.
	 * @see LoadKey
	 */
	@Override
	public PrivateKey loadKey(byte[] origen) throws RuntimeException {
		try{
			PKCS8EncodedKeySpec encodeKey = new PKCS8EncodedKeySpec(origen);
			KeyFactory generator = KeyFactory.getInstance(MethodEncode.RSA);
			return generator.generatePrivate(encodeKey);
		}catch(Exception exception) {
			throw new RuntimeException(exception);
		}
	}
}