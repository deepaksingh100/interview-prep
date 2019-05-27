package me.deepak.interview.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
*/
public class ActivitySelection {

	private ActivitySelection() {
	}

	/**
	 * Returns maximum activities done count from given start and end
	 */
	public static int maxActivities(int[] start, int[] end) {
		int length = start.length;
		Activity[] activities = new Activity[length];
		for (int i = 0; i < length; i++) {
			activities[i] = new Activity(i + 1, start[i], end[i]);
		}

		// sort activities in non-descending order of end time
		Arrays.sort(activities,
				(Activity activity1, Activity activity2) -> Integer.compare(activity1.end, activity2.end));

		// count of non overlapping activities, always count first ending activity
		int count = 1;

		// index of last non overlapping activity, always count first ending activity
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

	/**
	 * Returns maximum activities done in sequence from given start and end
	 */
	public static List<Activity> maxActivitiesSolution(int[] start, int[] end) {
		int length = start.length;
		Activity[] activities = new Activity[length];
		for (int i = 0; i < length; i++) {
			activities[i] = new Activity(i + 1, start[i], end[i]);
		}

		// sort activities in non-ascending order of end time
		Arrays.sort(activities,
				(Activity activity1, Activity activity2) -> Integer.compare(activity1.end, activity2.end));

		// Holds optimal sequence, which gains optimal solution
		List<Activity> sequence = new ArrayList<>();

		// always add first ending activity to answer
		sequence.add(activities[0]);

		// index of last non overlapping activity, always add first ending activity to
		// answer
		int index = 0;

		for (int i = 1; i < length; i++) {

			// if current activity's start is after previously non overlapping activity's
			// end add this activity to answer, update index to i
			if (activities[i].start >= activities[index].end) {
				sequence.add(activities[i]);
				index = i;
			}
		}
		return sequence;
	}

	static final class Activity {
		int id;
		int start;
		int end;

		private Activity(int id, int start, int end) {
			this.id = id;
			this.start = start;
			this.end = end;
		}
	}

}
