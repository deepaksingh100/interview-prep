package me.deepak.interview.geeksforgeeks;

/*
 * https://practice.geeksforgeeks.org/problems/left-out-candies/0
*/
public class LeftOutCandies {

	private LeftOutCandies() {
	}

	// SIGMA_N[i] denotes 1 + 2 + 3 + ... + i
	private static final int[] SIGMA_N = new int[51];

	public static int getLeftOutCandies(int studentsCount, int candiesCount) {
		populateSigmaN();

		// number of candies left for last pass
		candiesCount %= SIGMA_N[studentsCount];

		// find just smallest candies to be distributed & subtract from candies count
		return candiesCount - justSmallest(studentsCount, candiesCount);
	}

	// too simple, figure it out
	private static void populateSigmaN() {
		for (int i = 1; i <= 50; i++) {
			SIGMA_N[i] = SIGMA_N[i - 1] + i;
		}
	}

	// this method find just smallest number than given key
	private static int justSmallest(int high, int key) {

		// start for first student
		int low = 1;
		int ans = 0;

		while (low <= high) {
			int mid = (low + high) >>> 1;

			// if mid value is less than OR equals to key, update ans & move low to mid + 1,
			// else set high to mid - 1
			if (SIGMA_N[mid] <= key) {
				ans = SIGMA_N[mid];
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

}
