package me.deepak.interview.bits;

/*
 * https://www.geeksforgeeks.org/set-rightmost-unset-bit-2/
*/
public class TurnOnRightmostUnsetBit {

	private TurnOnRightmostUnsetBit() {
	}

	/*
	 * Let the input number be n. n+1 would have all the bits flipped after the
	 * rightmost unset bit (including the unset bit). So, doing n|(n+1) would give
	 * us the required result.
	 */
	public static int turnOn(int n) {
		return n | (n + 1);
	}

}
