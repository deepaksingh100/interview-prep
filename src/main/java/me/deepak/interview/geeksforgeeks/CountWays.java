package me.deepak.interview.geeksforgeeks;

/*
 * https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair/0
*/
public class CountWays {

	private CountWays() {
	}

	public static int count(int n) {

		int[] fibonaccis = new int[n + 1];
		
		// 0th and 1st number of the series are 0 and 1
		fibonaccis[0] = 1;
		fibonaccis[1] = 1;

		for (int i = 2; i < n; i++) {

			/*
			 * Add the previous 2 numbers in the series and store it
			 */
			fibonaccis[i] = fibonaccis[i - 1] + fibonaccis[i - 2];
		}

		return fibonaccis[n];
	}

}
