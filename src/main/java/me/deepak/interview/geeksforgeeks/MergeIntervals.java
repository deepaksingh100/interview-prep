package me.deepak.interview.geeksforgeeks;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/merge-intervals/
 * https://www.geeksforgeeks.org/merging-intervals/
*/
public class MergeIntervals {

	public int[][] merge(int[][] intervals) {

		if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
			return new int[][] {};
		}

		// sorting array in ascending order of start time
		Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

		// index will store last index of merged intervals
		int index = 0;

		// first interval will always there in answer, so starting from i = 1
		for (int i = 1; i < intervals.length; i++) {

			if (intervals[index][1] < intervals[i][0]) {

				// if last merged interval's end is smaller than start of current interval
				// this is a new interval, increase index & put this interval
				intervals[++index] = intervals[i];
			} else if (intervals[index][1] < intervals[i][1]) {

				// else if last merged interval's end is smaller than end of current interval
				// this interval should be merged with the previous one, update end of interval
				// at index
				intervals[index][1] = intervals[i][1];
			}
		}

		return Arrays.copyOfRange(intervals, 0, index + 1);
	}

}
