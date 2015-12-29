package org.encrypt.interfaces;

import java.util.Optional;

public interface Decode<T> {
	Optional<T> decode(byte[] message) throws RuntimeException;
}
