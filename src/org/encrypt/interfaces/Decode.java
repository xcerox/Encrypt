package org.encrypt.interfaces;

import java.util.Optional;

public interface Decode<T> {
	/**
	 * Metodo para Descifrar Mensaje
	 * @param message Arreglo de bytes del mensaje a descifrar.
	 * @return Optional con arreglo de bytes del mensaje descifrado.
	 * @throws RuntimeException
	 */
	Optional<T> decode(byte[] message) throws RuntimeException;
}
