package me.deepak.interview.geeksforgeeks;

public class Fibonacci {

	private Fibonacci() {
	}

	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		int f1 = 0;
		int f2 = 1;
		for (int i = 2; i <= n; i++) {
			int fib = f1 + f2;
			f1 = f2;
			f2 = fib;
		}
		return f2;
	}

}
