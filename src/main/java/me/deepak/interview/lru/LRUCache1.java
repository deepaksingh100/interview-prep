package me.deepak.interview.lru;

import java.util.HashMap;
import java.util.Map;

/*
 * LRU Cache implementation using Map & Linked List
 * 
 */

public class LRUCache1 {

	private int capacity;
	private Map<Integer, Node> map;
	private Node head;
	private Node tail;

	public LRUCache1(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		Node node = map.get(key);
		remove(node);
		setHead(node);
		return node.value;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			remove(node);
			setHead(node);
		} else {
			if (map.size() == capacity) {
				map.remove(tail.key);
				remove(tail);
			}
			Node node = new Node(key, value);
			setHead(node);
			map.put(key, node);
		}
	}

	private void remove(Node node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			tail = node.prev;
		}
	}

	private void setHead(Node node) {
		if (head != null) {
			head.prev = node;
		}
		node.next = head;
		node.prev = null;
		head = node;
		if (tail == null) {
			tail = head;
		}
	}

	private static class Node {
		int key;
		int value;
		Node prev;
		Node next;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

}
