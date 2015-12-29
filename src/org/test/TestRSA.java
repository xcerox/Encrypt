package org.test;

import static org.junit.Assert.*;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.util.Base64;
import java.util.Optional;

import org.encrypt.method.EncodeRSA;
import org.encrypt.method.key.rsa.LoadPrivateKey;
import org.encrypt.method.key.rsa.RSAKeyFactory;
import org.junit.Test;

public class TestRSA {

	@Test
	public void test() {
		EncodeRSA encodeRSA = new EncodeRSA();
		String message = "hola";
		KeyPair keys = new RSAKeyFactory().create();
		encodeRSA.setKeyEncrypt(keys.getPublic());
		Optional<byte[]> messageEncode = encodeRSA.encode(message.getBytes());
		if(messageEncode.isPresent()){
			byte[] encode = messageEncode.get();
			encodeRSA.setKeyDecrypt(keys.getPrivate());
			Optional<byte[]> messageDecode = encodeRSA.decode(encode);
			if(messageDecode.isPresent()){
				byte[] decode = messageDecode.get();
				if(message.equals(new String(decode))){
					String privateKeyBase64 = Base64.getEncoder().encodeToString(keys.getPrivate().getEncoded());
					byte[] privateKeyDecode = Base64.getDecoder().decode(privateKeyBase64.getBytes());
					PrivateKey newPrivateKey = new LoadPrivateKey().loadKey(privateKeyDecode);
					encodeRSA.setKeyDecrypt(newPrivateKey);
					Optional<byte[]> newMessageDecode = encodeRSA.decode(encode);
					if(newMessageDecode.isPresent()){
						byte[] newDecode = newMessageDecode.get();
						assertEquals(new String(decode),new String(newDecode));
					}
				}	
			}
		}
	}
}
