package me.deepak.interview.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/job-sequencing-problem/
 * https://www.youtube.com/watch?v=zPtI8q9gvX8
*/
public class JobSequencing {

	private JobSequencing() {
	}

	/**
	 * Returns maximum profit from given profits and deadlines
	 */
	public static int sequenceJob(int[] deadline, int[] profit) {
		int length = deadline.length;
		Job[] jobs = new Job[length];
		for (int i = 0; i < length; i++) {
			jobs[i] = new Job(i + 1, deadline[i], profit[i]);
		}

		// sort jobs in non-ascending order of profit
		Arrays.sort(jobs, (Job job1, Job job2) -> Integer.compare(job2.profit, job1.profit));

		// Number of total slots are maximum of deadlines, slotOccupied[i] == true means
		// that ith slot is occupied else not occupied
		boolean[] slotOccupied = new boolean[Arrays.stream(deadline).max().getAsInt()];

		int maxProfit = 0;

		// process all jobs one by one
		for (int i = 0; i < length; i++) {

			// Check if jobs[i] can be completed in last hour
			for (int j = jobs[i].deadline - 1; j >= 0; j--) {

				// j starts from last deadline hour, if slot j in unoccupied add profit of
				// jobs[i] to max profit & occupy the slot. Then break.
				if (!slotOccupied[j]) {
					maxProfit += jobs[i].profit;
					slotOccupied[j] = true;
					break;
				}
			}
		}
		return maxProfit;
	}

	/**
	 * Returns jobs in sequence which yields maximum profit from given profits and
	 * deadlines
	 */
	public static List<Job> sequenceJobSolution(int[] deadline, int[] profit) {
		int length = deadline.length;
		Job[] jobs = new Job[length];
		for (int i = 0; i < length; i++) {
			jobs[i] = new Job(i + 1, deadline[i], profit[i]);
		}

		// sort jobs in non-ascending order of profit
		Arrays.sort(jobs, (Job job1, Job job2) -> Integer.compare(job2.profit, job1.profit));

		// Number of total slots are maximum of deadlines, slotOccupied[i] == true means
		// that ith slot is occupied else not occupied
		boolean[] slotOccupied = new boolean[Arrays.stream(deadline).max().getAsInt()];

		// Holds optimal sequence, which gains optimal solution
		List<Job> sequence = new ArrayList<>();

		// process all jobs one by one
		for (int i = 0; i < length; i++) {

			// Check if jobs[i] can be completed in last hour
			for (int j = jobs[i].deadline - 1; j >= 0; j--) {

				// j starts from last deadline hour, if slot j in unoccupied add jobs[i] to
				// optimal sequence & occupy the slot. Then break.
				if (!slotOccupied[j]) {
					sequence.add(jobs[i]);
					slotOccupied[j] = true;
					break;
				}
			}
		}
		return sequence;
	}

	static final class Job {
		int id;
		int deadline;
		int profit;

		private Job(int id, int deadline, int profit) {
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}

	}

}
