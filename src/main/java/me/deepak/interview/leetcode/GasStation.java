package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/gas-station/
*/
public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {

		// current amount of gas in car tank
		int gasInTank = 0;

		// pump from where we have started current tour
		int startingPump = 0;

		// sum of given gas till every i
		int gasSum = 0;

		// sum of given cost till every i
		int costSum = 0;

		for (int i = 0; i < gas.length; i++) {

			// we will use gasSum & costSum directly for final answer
			gasSum += gas[i];
			costSum += cost[i];

			// update gas in tank
			gasInTank += gas[i] - cost[i];

			// if gas in tank is negative, we can't complete the circuit from startingPump
			if (gasInTank < 0) {

				// reset gasInTank & startingPump
				gasInTank = 0;
				startingPump = i + 1;
			}
		}

		// if total cost exceeds total gas, it's impossible to find solution
		return costSum > gasSum ? -1 : startingPump;
	}

}
