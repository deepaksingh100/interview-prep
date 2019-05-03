package me.deepak.interview.lru;

import java.util.HashMap;
import java.util.Map;

/*
 * LRU Cache implementation using Map & Doubly Linked List
 * 
 * https://www.geeksforgeeks.org/lru-cache-implementation/
 * https://www.geeksforgeeks.org/design-a-data-structure-for-lru-cache/
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache1 {

	private int capacity;
	private Map<Integer, Node> cache;
	private Node head;
	private Node tail;

	public LRUCache1(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<>();
	}

	public int get(int key) {
		Node node = cache.get(key);

		// if key is not in cache return -1
		if (node == null) {
			return -1;
		}

		// remove node & insert it to head of list
		remove(node);
		setHead(node);
		return node.value;
	}

	public void put(int key, int value) {
		Node node = cache.get(key);
		if (node != null) {

			// if cache has key, set new value, remove it & insert it to head of list
			node.value = value;
			remove(node);
			setHead(node);
		} else {

			// if cache has not key
			if (cache.size() == capacity) {

				// and cache is full, remove key from cache & remove node at tail (least
				// recently used)
				cache.remove(tail.key);
				remove(tail);
			}

			// and if cache is not full, create new new node with given key & value, insert
			// to head & put that key and node in cache
			node = new Node(key, value);
			setHead(node);
			cache.put(key, node);
		}
	}

	private void remove(Node node) {

		if (node.prev != null) {

			// if node is not head, set it's prev's next to it's next
			node.prev.next = node.next;
		} else {

			// else make node's next head
			head = node.next;
		}

		if (node.next != null) {

			// if node is not tail, set it's next's prev to it's next
			node.next.prev = node.prev;
		} else {

			// else make node's prev tail
			tail = node.prev;
		}
	}

	private void setHead(Node node) {
		if (head != null) {

			// if head is not null, set it's prev to node
			head.prev = node;
		}

		// set node's next & prev
		node.next = head;
		node.prev = null;

		// make node head
		head = node;
		if (tail == null) {

			// if tail is null make head tail also
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
