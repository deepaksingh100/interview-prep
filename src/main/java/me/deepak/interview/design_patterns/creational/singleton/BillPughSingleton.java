package me.deepak.interview.design_patterns.creational.singleton;

/*
 * https://stackoverflow.com/questions/6109896/singleton-pattern-bill-pughs-solution
*/
public class BillPughSingleton {

	private BillPughSingleton() {
	}

	/*
	 * The JLS guarantees that a class is only loaded when it's used for the first
	 * time (making the singleton initialization lazy), and that the class loading
	 * is thread-safe (making the getInstance() method thread-safe as well)
	 */
	private static final class SingletonHelper {
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}

	public static BillPughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
}
