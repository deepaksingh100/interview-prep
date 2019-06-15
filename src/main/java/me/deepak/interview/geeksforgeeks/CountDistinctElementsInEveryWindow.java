package me.deepak.interview.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

/*
 * https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
*/
public class CountDistinctElementsInEveryWindow {

	public int[] countDistinct(int[] a, int k) {
		int n = a.length;

		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int[] result = new int[n - k + 1];
		int j = 0;

		for (int i = 0; i < k; i++) {
			Integer val = map.get(a[i]);
			if (val == null) {
				count++;
				val = 0;
			}
			map.put(a[i], ++val);
		}

		result[j++] = count;

		for (int i = k; i < n; i++) {
			if (a[i] != a[i - k]) {
				Integer oldVal = map.get(a[i - k]);
				if (oldVal == 1) {
					count--;
				}
				map.put(a[i - k], --oldVal);
				Integer newVal = map.get(a[i]);
				if (newVal == null || newVal == 0) {
					count++;
					newVal = 0;
				}
				map.put(a[i], ++newVal);
			}
			result[j++] = count;
		}

		return result;
	}

}
