package org.test;

import static org.junit.Assert.*;

import java.util.Optional;

import org.encrypt.interfaces.Encode;
import org.encrypt.method.EncodeMD5;
import org.junit.Test;

public class TestMD5 {

	@Test
	public void test() {
		boolean isComplete = true;
		byte[] message = "hola".getBytes(), messageOrigin = null, messageNew = null;
		Encode<byte[]> encryptMD5 = new EncodeMD5();
		Optional<byte[]> messageEncodeOrigin = encryptMD5.encode(message);

		
		if(messageEncodeOrigin.isPresent())
			messageOrigin = messageEncodeOrigin.get();
			for (int i = 0; i < 10; i++) {
				Optional<byte[]> messageEncodeNew = encryptMD5.encode(message);
				if(messageEncodeNew.isPresent()){
					messageNew = messageEncodeOrigin.get();
					if(!messageNew.equals(messageOrigin)){
						isComplete = false;
						break;
					}
				}else
					isComplete = false;
			}
		
		assertTrue(isComplete);
	}

}
