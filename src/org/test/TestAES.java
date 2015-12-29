package org.test;

import static org.junit.Assert.*;

import java.security.Key;
import java.util.Optional;

import org.encrypt.method.EncodeAES;
import org.encrypt.method.key.aes.AESKeyFactory;
import org.junit.Test;

public class TestAES {

	@Test
	public void test() {
		EncodeAES encodeAES = new EncodeAES();
		Key key = new AESKeyFactory().create();
		encodeAES.setKey(key);
		String message = "hola";
		Optional<byte[]> messageEncode = encodeAES.encode(message.getBytes());
		if(messageEncode.isPresent()){
			byte[] encode = messageEncode.get();
			Optional<byte[]> messageDecode = encodeAES.decode(encode);
			if(messageDecode.isPresent()){
				byte[] decode = messageDecode.get();
				assertEquals(new String(decode), message);
			}
		}
	}

}
