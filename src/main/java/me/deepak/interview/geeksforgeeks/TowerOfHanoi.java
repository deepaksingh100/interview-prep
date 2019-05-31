package me.deepak.interview.geeksforgeeks;

/*
 * https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
*/
public class TowerOfHanoi {

	private TowerOfHanoi() {
	}

	public static void towerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
		if (n == 1) {
			System.out.println("Move disk '1' from rod '" + fromRod + "' to rod '" + toRod + "'.");
			return;
		}
		towerOfHanoi(n - 1, fromRod, auxRod, toRod);
		System.out.println("Move disk '" + n + "' from rod '" + fromRod + "' to rod '" + toRod + "'.");
		towerOfHanoi(n - 1, auxRod, toRod, fromRod);
	}

}
