package me.deepak.interview.design.patterns.creational.singleton;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1021859217681904832L;

	private SerializableSingleton() {
	}

	private static final class SingletonHelper {
		private static final SerializableSingleton INSTANCE = new SerializableSingleton();
	}

	public static SerializableSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}

	private Object readResolve() {
		return SingletonHelper.INSTANCE;
	}
}
