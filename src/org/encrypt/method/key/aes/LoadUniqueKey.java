package org.encrypt.method.key.aes;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

import org.encrypt.interfaces.LoadKey;
import org.encrypt.util.MethodEncode;

public class LoadUniqueKey implements LoadKey<Key, byte[]> {

	@Override
	public Key loadKey(byte[] origen) throws RuntimeException {
		return new SecretKeySpec(origen, MethodEncode.AES);
	}

}
