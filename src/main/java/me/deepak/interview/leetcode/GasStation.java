package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/gas-station/
*/

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int tank = 0;
		int pump = 0;
		int gasSum = 0;
		int costSum = 0;
		for (int i = 0; i < gas.length; i++) {
			gasSum += gas[i];
			costSum += cost[i];
			tank += gas[i] - cost[i];
			if (tank < 0) {
				tank = 0;
				pump = i + 1;
			}
		}
		return costSum > gasSum ? -1 : pump;
	}

}
