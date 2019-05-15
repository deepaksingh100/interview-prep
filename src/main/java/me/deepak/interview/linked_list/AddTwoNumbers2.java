package me.deepak.interview.linked_list;

import static me.deepak.interview.linked_list.Reverse.reverse;

import me.deepak.interview.linked_list.beans.Node;

/*
 * https://leetcode.com/problems/add-two-numbers-ii/
*/
public class AddTwoNumbers2 {

	private AddTwoNumbers2() {
	}

	public static Node addTwoNumbers(Node l1, Node l2) {
		l1 = reverse(l1);
		l2 = reverse(l2);
		return reverse(AddTwoNumbers.addTwoNumbers(l1, l2));
	}

}
