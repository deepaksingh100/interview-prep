package me.deepak.interview.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
*/
public class InfixToPostFix {

	private InfixToPostFix() {
	}

	public static char[] convert(char[] infix) {
		StringBuilder postfix = new StringBuilder();
		Deque<Character> operatorStack = new ArrayDeque<>();
		for (char c : infix) {
			if (c == '(') {
				operatorStack.push(c);
			} else if (c == ')') {
				while (operatorStack.peek() != '(') {
					postfix.append(operatorStack.pop());
				}
				operatorStack.pop();
			} else if (isOperator(c)) {
				while (!operatorStack.isEmpty() && getPrecedence(c) <= getPrecedence(operatorStack.peek())) {
					postfix.append(operatorStack.pop());
				}
				operatorStack.push(c);
			} else {
				postfix.append(c);
			}
		}
		while (!operatorStack.isEmpty()) {
			postfix.append(operatorStack.pop());
		}
		return postfix.toString().toCharArray();
	}

	private static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
	}

	private static byte getPrecedence(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}
	}

}
