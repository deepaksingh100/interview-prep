package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/gas-station/
 * https://leetcode.com/problems/gas-station/discuss/42568/Share-some-of-my-ideas.
*/
public class GasStation {

	/*
	 * Why this solution works? There are two points : 1) If car starts at A and can
	 * not reach B. Any station between A and B can not reach B.(B is the first
	 * station that A can not reach.). 2) If the total number of gas is bigger than
	 * the total number of cost. There must be a solution.
	 * 
	 * Proof to the first point: say there is a point C between A and B -- that is A
	 * can reach C but cannot reach B. Since A cannot reach B, the gas collected
	 * between A and B is short of the cost. Starting from A, at the time when the
	 * car reaches C, it brings in gas >= 0, and the car still cannot reach B. Thus
	 * if the car just starts from C, it definitely cannot reach B.
	 */
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
