package me.deepak.interview.geeksforgeeks;

/*
 * https://www.geeksforgeeks.org/queries-sum-prime-factor-counts-range/
*/
public class CountPrimeFactorsInRange {

	private static long[] factorCount;

	private CountPrimeFactorsInRange() {
	}

	public static void preprocess(int n) {
		sieveOfEratosthenes(n);
		accumulateFactorCounts(n);
	}

	public static long countFactorsInRange(int left, int right) {
		return factorCount[right] - factorCount[left - 1];
	}

	private static void sieveOfEratosthenes(int n) {

		// create a int array "factorCount[0..n]" and initialize
		// all entries it as 0. A value in factorCount[i] will
		// increase if i is Not a prime, else set 1.
		factorCount = new long[n + 1];

		for (int i = 2; i * i <= n; i++) {

			// if factorCount[i] is not changed, then it is a prime
			if (factorCount[i] == 0) {

				// update all multiples of p
				for (int j = i * i; j <= n; j += i) {
					factorCount[j]++;
				}
				factorCount[i] = 1;
			}
		}
	}

	private static void accumulateFactorCounts(int n) {
		for (int i = 1; i <= n; i++) {
			factorCount[i] += factorCount[i - 1];
		}
	}

}
