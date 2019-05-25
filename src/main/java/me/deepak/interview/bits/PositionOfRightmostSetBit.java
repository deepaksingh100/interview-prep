package me.deepak.interview.bits;

/*
 * https://www.geeksforgeeks.org/position-of-rightmost-set-bit/
*/
public class PositionOfRightmostSetBit {

	private PositionOfRightmostSetBit() {
	}

	public static int getFirstSetBitPos(int n) {

		// -n in java is two's complement
		return n > 0 ? (int) ((Math.log10(n & -n)) / Math.log10(2)) + 1 : -1;
	}

}
