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
		//Encriptacion de mensaje
		encodeRSA.setKeyEncrypt(keys.getPublic());
		Optional<byte[]> messageEncode = encodeRSA.encode(message.getBytes());
		
		if(messageEncode.isPresent()){
			byte[] encode = messageEncode.get();
			encodeRSA.setKeyDecrypt(keys.getPrivate());
			Optional<byte[]> messageDecode = encodeRSA.decode(encode);
			if(messageDecode.isPresent()){
			byte[] decode = messageDecode.get();
			//Verificacion de que se encripto correctamente
			if(message.equals(new String(decode))){
					//conversion de llave a string y de nuevo a llave para probar las clases loadKey
					String privateKeyBase64 = Base64.getEncoder().encodeToString(keys.getPrivate().getEncoded());
					byte[] privateKeyDecodeBase64 = Base64.getDecoder().decode(privateKeyBase64.getBytes());
					PrivateKey newPrivateKey = new LoadPrivateKey().loadKey(privateKeyDecodeBase64);
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
