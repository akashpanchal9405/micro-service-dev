package com.inn.singleton;

import java.io.Serializable;

public class MySingleton implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private static MySingleton instance;

	private MySingleton() {
		if (instance != null) {
			throw new IllegalArgumentException("singleton instance already created!");
		}
	}

	public static MySingleton getInstance() {
		if (instance == null) {// first check
			synchronized (MySingleton.class) {
				if (instance == null) {// second check for multi-threading safety
					instance = new MySingleton();
				}

			}
		}
		return instance;
	}

	// to avoid multiple object through Serialization and deserialization

	public Object readResolve() {
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new CloneNotSupportedException("Singleton cloning in not allowed");
	}
}
