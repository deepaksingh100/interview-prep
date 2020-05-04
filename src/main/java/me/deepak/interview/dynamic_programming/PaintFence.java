package me.deepak.interview.dynamic_programming;

/*
 * https://leetfree.com/problems/paint-fence.html
 * https://youtu.be/deh7UpSRaEY
*/
public class PaintFence {

	public int numWays(int n, int k) {

		// for 0 posts we have 0 ways
		if (n == 0) {
			return 0;
		}

		// for 1 post we have k ways
		if (n == 1) {
			return k;
		}

		// if first and second post have same color, number of ways will be k * 1.
		// number of ways to choose first color is k & number of ways to choose first
		// color is 1
		int same = k * 1;

		// if first and second post have different color, number of ways will be k * (k
		// - 1). number of ways to choose first color is k & number of ways to choose
		// first color is k - 1
		int diff = k * (k - 1);

		for (int i = 3; i <= n; i++) {
			int prevDiff = diff;

			// number of ways to choose different color as previous post for current post is
			// k - 1. It did not matter if previous two posts have same or different color.
			diff = (same + diff) * (k - 1);

			// number of ways to choose same color as previous post for current post is
			// 1. If previous two posts are same we can not include `same`. Thus we only
			// include `diff`
			same = prevDiff * 1;
		}
		
		// return the final total number of ways
		return same + diff;
	}

}
