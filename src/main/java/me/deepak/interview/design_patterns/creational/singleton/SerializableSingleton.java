package me.deepak.interview.design_patterns.creational.singleton;

import java.io.Serializable;

/*
 * https://www.linkedin.com/pulse/issues-resolutions-singleton-design-pattern-java-pratapi-hemant-patel/
*/
public final class SerializableSingleton implements Serializable {

	private static final long serialVersionUID = -1021859217681904832L;

	private SerializableSingleton() {
	}

	private static final class SingletonHelper {
		private static final SerializableSingleton INSTANCE = new SerializableSingleton();
	}

	public static SerializableSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}

	/*
	 * The readResolve() method allows final tweaks to the state of an object during
	 * deserialization. readResolve() is used for replacing the object read from the
	 * stream.
	 */
	private Object readResolve() {
		return SingletonHelper.INSTANCE;
	}
}
