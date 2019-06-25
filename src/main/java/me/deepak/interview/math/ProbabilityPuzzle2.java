package me.deepak.interview.math;

import java.util.Random;

/*
 * https://www.geeksforgeeks.org/generate-integer-from-1-to-7-with-equal-probability/
*/
public class ProbabilityPuzzle2 {

	private ProbabilityPuzzle2() {
	}

	// Generates a pseudo-random integer in the range [min, max]
	private static int random(int min, int max) {
		int rangeLength = max - min + 1;
		if (min > max || rangeLength > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Invalid range");
		}
		return new Random().nextInt(rangeLength) + min;
	}

	// generate random numbers between 1 to 7 with equal probability using a
	// function that generates random numbers from 1 to 5 with equal probability
	public static int myRandom() {

		// generate two random numbers from 1 to 6 with equal probability
		int x = random(1, 5);
		int y = random(1, 5);

		int num = 5 * x + y - 5;
		if (num < 22) {
			return (num % 7) + 1;
		}
		return myRandom();
	}

	public static void main(String[] args) {

		int[] freq = new int[8];

		for (int i = 0; i < 1000000; i++) {
			int val = myRandom();
			freq[val]++;
		}

		for (int i = 1; i <= 7; i++) {
			System.out.println(i + " ~ " + freq[i] / 10000.0);
		}
	}

}
