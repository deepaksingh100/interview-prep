package me.deepak.interview.geeksforgeeks;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/sieve-of-eratosthenes/
*/
public class SieveOfEratosthenes {

	private SieveOfEratosthenes() {
	}

	public static boolean[] sieveOfEratosthenes(int n) {

		// create a boolean array "prime[0..n]" and initialize
		// all entries it as true. A value in prime[i] will
		// finally be false if i is Not a prime, else true.
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);

		prime[0] = false;
		prime[1] = false;

		for (int i = 2; i * i <= n; i++) {

			// if prime[i] is not changed, then it is a prime
			if (prime[i]) {

				// update all multiples of p
				for (int j = i * i; j <= n; j += i) {
					prime[j] = false;
				}
			}
		}
		return prime;
	}

}
