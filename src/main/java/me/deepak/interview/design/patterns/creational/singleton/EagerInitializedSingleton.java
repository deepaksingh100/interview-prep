package me.deepak.interview.design.patterns.creational.singleton;

public class EagerInitializedSingleton {

	private static final EagerInitializedSingleton INSTANCE = new EagerInitializedSingleton();

	private EagerInitializedSingleton() {
	}

	public static EagerInitializedSingleton getInstance() {
		return INSTANCE;
	}

}
