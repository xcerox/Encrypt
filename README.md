# Encrypt
Libreria para cifrar utilizando diferentes métodos.

	Creada con Eclipse Luna 4.4.2, Java 8, JUnit 4.

**Ejemplo de Encriptación con MD5.**
```java
		String message = "Hola";
		Encode<byte[]> cipher = new EncodeMD5();
		Optional<byte[]> messageEncode = cipher.encode(message.getBytes());
		if(messageEncode.isPresent()){
			String resultEncode = new String(messageEncode.get());
			System.out.println("Resultado: " + resultEncode);
		}
```
    	Resultado: öˆ®&éÏ£ºb5Gx1Õ

**Ejemplo de Encriptación con SHA**
```java
		String message = "Hola";
		Encode<byte[]> cipher = new EncodeSHA1();
		Optional<byte[]> messageEncode = cipher.encode(message.getBytes());
		if(messageEncode.isPresent()){
			String resultEncode = new String(messageEncode.get());
			System.out.println("Resultado: " + resultEncode);
		}
```
    	Resultado: NFÜ	iæb-aÒ"Ž<ÙuÍžÜ

**Ejemplo de Encriptación con SHA 256**
```java    
		String message = "Hola";
		Encode<byte[]> cipher = new EncodeSHA256();
		Optional<byte[]> messageEncode = cipher.encode(message.getBytes());
		if(messageEncode.isPresent()){
			String resultEncode = new String(messageEncode.get());
			System.out.println("Resultado: " + resultEncode);
		}    
```
	Resultado: æ3ôüyºÞ¡Ü]¹pÏ9|‚HºÄ|Ã¬ù‘[¦]v°è?

**Ejemplo de Encriptación con SHA 384**
```java    
		String message = "Hola";
		Encode<byte[]> cipher = new EncodeSHA384();
		Optional<byte[]> messageEncode = cipher.encode(message.getBytes());
		if(messageEncode.isPresent()){
			String resultEncode = new String(messageEncode.get());
			System.out.println("Resultado: " + resultEncode);
		}  
```
	Resultado: unµá}^s´ï~7MäÅÖ·à^ÀÕÿS¦¨¥bàdámÂ¾Ós1JWÊ

**Ejemplo de Encriptación con SHA 512**
```java    
		String message = "Hola";
		Encode<byte[]> cipher = new EncodeSHA512();
		Optional<byte[]> messageEncode = cipher.encode(message.getBytes());
		if(messageEncode.isPresent()){
			String resultEncode = new String(messageEncode.get());
			System.out.println("Resultado: " + resultEncode);
		}
```
	Resultado: À–†â8×à¦Ó’œ{ oF?>k{(+¤?U?„WˆÅ

**Ejemplo de Encriptación con AES encriptacion Simetrica**
```java    
		String message = "Hola";
		EncodeAES cipher = new EncodeAES();
		
		//Creación y asignación de llave para cifrar y descifrar.
		Key key = new AESKeyFactory().create();
		cipher.setKey(key);
	
		Optional<byte[]> meesageEncode = cipher.encode(message.getBytes());
		if(meesageEncode.isPresent()){
			String resultEncode = new String(meesageEncode.get());
			System.out.println("Mensaje codificado: " + resultEncode);
		
			Optional<byte[]> messageDecode = cipher.decode(resultEncode.getBytes());
			if(messageDecode.isPresent()){
				String resultDecode = new String(messageDecode.get());
				System.out.println("Mensaje decodificado: " + resultDecode);
			}
			
		}
```
	Mensaje codificado: <K†ÁíÂ‡ëÑ;…ôèÞ
	Mensaje decodificado: Hola

**Ejemplo de Encriptación con RSA encriptacion Asimetrica**	
```java    
		String message = "Hola";
		EncodeRSA cipher = new EncodeRSA();
		KeyPair keys = new RSAKeyFactory().create();
		
		cipher.setKeyEncrypt(keys.getPublic());
		Optional<byte[]> meesageEncode = cipher.encode(message.getBytes());
		if(meesageEncode.isPresent()){
			//se codifica en base64 para mantener todos sus bytes intactos. 
			String resultEncode = Base64.getEncoder().encodeToString(meesageEncode.get());
			System.out.println("Mensaje codificado: " + resultEncode);
			
			cipher.setKeyDecrypt(keys.getPrivate());
			Optional<byte[]> messageDecode = cipher.decode(Base64.getDecoder().decode(resultEncode.getBytes()));
			if(messageDecode.isPresent()){
				String resultDecode = new String(messageDecode.get());
				System.out.println("Mensaje decodificado: " + resultDecode);
			}
		}
```
	Mensaje codificado: jzdRpSDyNeMaDzOD/4LFh//dZmAFcPe9AQZkdHhPckjg0nuWUmJpHTUv5ea2M3svVIDaSkmF2X2sB1+WHufnyuIITHTZx10JsjSbAie0NERp2YRRQv5tnX9dfe7x7bzUGyRKB8ns+FbFAqfzj+F08/QDo+DqrdjrBumn2RhkaXc=
	Mensaje decodificado: Hola
