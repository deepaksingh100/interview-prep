package me.deepak.interview.greedy;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
*/
public class ActivitySelection {

	private ActivitySelection() {
	}

	public static int maxActivities(int[] start, int[] end) {
		int length = start.length;
		Activity[] activities = new Activity[length];
		for (int i = 0; i < length; i++) {
			activities[i] = new Activity(start[i], end[i]);
		}

		// sort activities in non-ascending order of end time
		Arrays.sort(activities,
				(Activity activity1, Activity activity2) -> Integer.compare(activity1.end, activity2.end));

		// count of non overlapping activities
		int count = 1;

		// index of last non overlapping activity
		int index = 0;

		for (int i = 1; i < length; i++) {

			// if current activity's start is after previously non overlapping activity's
			// end add this activity to answer, update index to i
			if (activities[i].start >= activities[index].end) {
				count++;
				index = i;
			}
		}
		return count;
	}

	private static final class Activity {
		private int start;
		private int end;

		private Activity(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

}
