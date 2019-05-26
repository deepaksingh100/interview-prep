package me.deepak.interview.bits;

/*
 * https://www.geeksforgeeks.org/turn-off-the-rightmost-set-bit/
*/
public class TurnOffRightmostSetBit {

	private TurnOffRightmostSetBit() {
	}

	/*
	 * Let the input number be n. n-1 would have all the bits flipped after the
	 * rightmost set bit (including the set bit). So, doing n&(n-1) would give us
	 * the required result.
	 */
	public static int turnOff(int n) {
		return n & (n - 1);
	}

}
