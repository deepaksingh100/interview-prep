package me.deepak.interview.geeksforgeeks;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * https://www.geeksforgeeks.org/queue-based-approach-for-first-non-repeating-character-in-a-stream/
*/
public class FirstNonRepeatingCharInStream {

	private FirstNonRepeatingCharInStream() {
	}

	public static int[] getFirstNonRepeating(char[] stream) {
		int length = stream.length;
		int[] result = new int[length];

		// count array of size 26(assuming only lower case characters are present)
		int[] count = new int[26];

		// queue to store Characters
		Queue<Character> queue = new ArrayDeque<>(26);

		// traverse whole stream
		for (int i = 0; i < length; i++) {

			// push each character in queue
			queue.add(stream[i]);

			// increment the frequency count
			count[stream[i] - 'a']++;

			// check for the non repeating character
			while (!queue.isEmpty()) {
				if (count[queue.peek() - 'a'] > 1) {
					queue.remove();
				} else {
					result[i] = queue.peek();
					break;
				}
			}
			if (queue.isEmpty()) {
				result[i] = -1;
			}
		}
		return result;
	}

}
