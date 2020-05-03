package me.deepak.interview.design_patterns.creational.singleton;

/*
 * http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
*/
public class DoubleCheckLockingSingleton {

	private static DoubleCheckLockingSingleton instance;

	private DoubleCheckLockingSingleton() {
	}

	// broken, should use synchronized at method level
	public static DoubleCheckLockingSingleton getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckLockingSingleton.class) {
				if (instance == null) {
					instance = new DoubleCheckLockingSingleton();
				}
			}
		}
		return instance;
	}
}
