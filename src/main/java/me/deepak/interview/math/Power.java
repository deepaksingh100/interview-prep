package me.deepak.interview.math;

/*
 * https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
 * https://www.geeksforgeeks.org/write-an-iterative-olog-y-function-for-powx-y/
*/
public class Power {

	private Power() {
	}

	public static double power(double x, int y) {
		if (y == 0) {
			return 1;
		}

		double temp = power(x, y / 2);

		if ((y & 1) == 0) {
			return temp * temp;
		}

		if (y > 0) {
			return x * temp * temp;
		}
		return (temp * temp) / x;
	}

	public static double powerIterative(double x, int y) {

		int result = 1;

		while (y != 0) {
			if ((y & 1) == 1) {
				if (y > 0) {
					result *= x;
				} else {
					result /= x;
				}
			}
			y >>= 1;
			x *= x;
		}

		return result;
	}

}
