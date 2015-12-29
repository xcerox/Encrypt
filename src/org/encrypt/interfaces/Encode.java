package org.encrypt.interfaces;

import java.util.Optional;

public interface Encode <T> {
	Optional<T> encode(byte[] message) throws RuntimeException;
}
