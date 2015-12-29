package org.encrypt.method;

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

	public void setKeyDecrypt(PrivateKey privateKey){
		this.privateKey = privateKey;
	}
	
	public void setKeyEncrypt(PublicKey publicKey){
		this.publicKey = publicKey;
	}
	
	private byte[] decryptor(byte[] message) throws Exception {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return cipher.doFinal(message);
	}

	private byte[] encryptor(byte[] message) throws Exception {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, publicKey, new SecureRandom());
		return cipher.doFinal(message);
	}

	@Override
	public Optional<byte[]> encode(byte[] message) throws RuntimeException {
		try{
			return Optional.of(encryptor(message));
		}catch(Exception exception){
			throw new RuntimeException(exception);
		}
	}

	@Override
	public Optional<byte[]> decode(byte[] message) throws RuntimeException {
		try{
			return Optional.of(decryptor(message));
		}catch(Exception exception){
			throw new RuntimeException(exception);
		}
	}
}
