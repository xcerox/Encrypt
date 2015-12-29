package org.encrypt.interfaces;

public interface KeyGenerator<T> {
	T create() throws RuntimeException;
}
