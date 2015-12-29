package org.encrypt.method;

import java.security.Key;
import java.util.Optional;

import javax.crypto.Cipher;

import org.encrypt.interfaces.Decode;
import org.encrypt.interfaces.Encode;

public class EncodeAES implements Encode<byte[]>, Decode<byte[]>{
	private final String algorithm = "AES/ECB/PKCS5Padding";
	private Key key;
	
	public void setKey(Key key){
		this.key = key;
	}
	
	private byte[] encrypt(byte[] message) throws Exception{
		Cipher encryptor = Cipher.getInstance(algorithm);
		encryptor.init(Cipher.ENCRYPT_MODE, key);
		return encryptor.doFinal(message);
	}
	
	private byte[] descrypt(byte[] message) throws Exception{
		Cipher descyptor = Cipher.getInstance(algorithm);
		descyptor.init(Cipher.DECRYPT_MODE, key);
		return descyptor.doFinal(message);
	}

	@Override
	public Optional<byte[]> decode(byte[] message) throws RuntimeException {
		try{
			return Optional.of(descrypt(message));
		}catch(Exception exception){
			throw new RuntimeException(exception);
		}
	}

	@Override
	public Optional<byte[]> encode(byte[] message) throws RuntimeException {
		try {
			return Optional.of(encrypt(message));
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}
	
}
