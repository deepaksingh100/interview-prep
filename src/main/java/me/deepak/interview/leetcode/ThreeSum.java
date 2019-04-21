package me.deepak.interview.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/3sum/
*/

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] a) {
		int n = a.length;
		Set<List<Integer>> triplets = new HashSet<>();
		for (int i = 0; i < n - 2; i++) {
			Set<Integer> set = new HashSet<>();
			int currentSum = -a[i];
			for (int j = i + 1; j < n; j++) {
				if (set.contains(currentSum - a[j])) {
					List<Integer> triplet = new ArrayList<>(3);
					triplet.add(a[i]);
					triplet.add(a[j]);
					triplet.add(currentSum - a[j]);
					triplet.sort(null);
					triplets.add(triplet);
				}
				set.add(a[j]);
			}
		}
		return new ArrayList<>(triplets);
	}

}
