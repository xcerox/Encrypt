package org.encrypt.interfaces;

public interface LoadKey<K, T>{
	/**
	 * Metodo para cargar llavo desde origem
	 * @param origen Generico que contiene la base para cargar una llave.
	 * @return Llave creada
	 * @throws RuntimeException
	 */
	K loadKey(T origen) throws RuntimeException;
}
