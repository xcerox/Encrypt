# Encrypt
Libreria para cifrar utilizando diferentes métodos.

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

Creada con Eclipse Luna 4.4.2, Java 8, JUnit 4.
