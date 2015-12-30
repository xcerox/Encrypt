package org.encrypt.interfaces;

import java.util.Optional;

public interface Encode <T> {
	/**
	 * Metodo para cifrar mensaje.
	 * @param message Arreglo de bytes del mensaje a cifrar
	 * @return Optional de tipo generico con el resultado del cifrado.
	 * @throws RuntimeException
	 */
	Optional<T> encode(byte[] message) throws RuntimeException;
}
