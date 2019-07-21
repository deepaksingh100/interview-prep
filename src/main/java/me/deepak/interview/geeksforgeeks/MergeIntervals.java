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

		Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

		int index = 0;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[index][1] < intervals[i][0]) {
				intervals[++index] = intervals[i];
			} else if (intervals[index][1] < intervals[i][1]) {
				intervals[index][1] = intervals[i][1];
			}
		}

		return Arrays.copyOfRange(intervals, 0, index + 1);
	}

}
