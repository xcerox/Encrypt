package org.test;

import static org.junit.Assert.*;

import java.security.KeyPair;
import java.util.Optional;

import org.encrypt.method.EncodeRSA;
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
				assertEquals((new String(decode)),message);
			}
		}
	}

}
