package me.deepak.interview.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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
		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			int[] top = stack.peek();
			if (top[1] < intervals[i][0]) {
				stack.push(intervals[i]);
			} else if (top[1] < intervals[i][1]) {
				top[1] = intervals[i][1];
			}
		}
		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty()) {
			int[] interval = stack.pop();
			result.insert(0, interval[1]).insert(0, " ").insert(0, interval[0]).insert(0, " ");
		}
		String[] temp = result.substring(1).split(" ");
		int[][] a = new int[temp.length / 2][2];
		for (int i = 0; i < temp.length; i += 2) {
			a[i / 2][0] = Integer.parseInt(temp[i]);
			a[i / 2][1] = Integer.parseInt(temp[i + 1]);
		}
		return a;
	}

}
