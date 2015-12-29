package org.encrypt.interfaces;

public interface LoadKey<K, T>{
	
	K loadKey(T origen) throws RuntimeException;
}
