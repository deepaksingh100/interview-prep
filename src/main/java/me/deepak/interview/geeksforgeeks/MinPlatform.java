package me.deepak.interview.geeksforgeeks;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 * https://www.hackerrank.com/contests/kilobyte-uz-contest1/challenges/trains-and-platforms/problem
*/
public class MinPlatform {

	private MinPlatform() {
	}

	public static int minPlatform(int[] arrivals, int[] departures) {
		Arrays.sort(arrivals);
		Arrays.sort(departures);

		// to iterate on arrivals
		int i = 0;

		// to iterate on departures
		int j = 0;

		// number of platform needed in current situation
		int platformNeeded = 0;

		// final result
		int result = 0;

		// iterate on arrivals
		while (i < arrivals.length) {

			if (arrivals[i] < departures[j]) {

				// a train has departed, increment arrivals' iterator, number of platform needed
				// update result
				i++;
				platformNeeded++;
				result = Math.max(platformNeeded, result);
			} else if (arrivals[i] > departures[j]) {

				// a train has arrived, increment departures' iterator, decrement number of
				// platform needed
				j++;
				platformNeeded--;
			} else {

				// else increment arrivals' & departures' iterator
				i++;
				j++;
			}
		}
		return result;
	}

}
