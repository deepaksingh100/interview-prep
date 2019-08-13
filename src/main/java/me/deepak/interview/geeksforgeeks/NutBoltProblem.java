package me.deepak.interview.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class NutBoltProblem {

	public void match(char[] nuts, char[] bolts) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < nuts.length; i++) {
			map.put(nuts[i], i);
		}

		for (int i = 0; i < bolts.length; i++) {
			System.out.println("Index of nut : " + map.get(bolts[i]) + ", bolt : " + i);
		}
	}

}
