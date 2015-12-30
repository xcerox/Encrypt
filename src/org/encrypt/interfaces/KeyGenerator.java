package org.encrypt.interfaces;

public interface KeyGenerator<T> {
	/**
	 * Metodo para crear lleves
	 * @return Generico con la llave creada.
	 * @throws RuntimeException
	 */
	T create() throws RuntimeException;
}
