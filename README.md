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

Creada con Eclipse Luna 4.4.2, Java 8, JUnit 4.
