package me.deepak.interview.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://www.geeksforgeeks.org/the-stock-span-problem/
*/
public class StockSpanProblem {

	private StockSpanProblem() {
	}

	public static int[] calculateSpan(int[] prices) {

		// create a stack and push index of first element to it
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0);

		int n = prices.length;
		int[] spans = new int[n];

		// span value of first element is always 1
		spans[0] = 1;

		// calculate span values for rest of the elements
		for (int i = 1; i < n; i++) {

			// decreasing stack. pop elements from stack while stack is not empty and top of
			// stack is smaller than prices[i]
			while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
				stack.pop();
			}

			// if stack becomes empty, then prices[i] is greater than all elements on left
			// of it, i.e., prices[0], prices[1], ... prices[i-1]. else prices[i] is greater
			// than elements after top of stack.
			spans[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

			// push this element to stack
			stack.push(i);
		}
		return spans;
	}

	public static void main(String[] args) {
		calculateSpan(new int[] { 100, 80, 60, 70, 60, 75, 85 });
	}

}
