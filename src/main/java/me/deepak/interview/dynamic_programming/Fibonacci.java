package me.deepak.interview.dynamic_programming;

public class Fibonacci {

	private Fibonacci() {
	}

	public static int fibonacci(int n) {

		// declare an array to store fibonacci numbers.
		// 1 extra to handle case, n = 0
		int[] fibonaccis = new int[n + 1];

		// 0th and 1st number of the series are 0 and 1
		fibonaccis[0] = 0;
		fibonaccis[1] = 1;

		for (int i = 2; i <= n; i++) {

			// add the previous 2 numbers in the series and store it
			fibonaccis[i] = fibonaccis[i - 1] + fibonaccis[i - 2];
		}

		return fibonaccis[n];
	}

}
