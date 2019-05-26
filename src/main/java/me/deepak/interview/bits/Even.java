package me.deepak.interview.bits;

public class Even {

	private Even() {
	}

	public static boolean isEven(int n) {
		return (n & 1) == 0;
	}

}
