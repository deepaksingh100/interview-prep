package me.deepak.interview.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * LRU Cache implementation using Linked Hash Map
 * 
 */

public class LRUCache2 {

	private final LRU<Integer, Integer> lru;

	public LRUCache2(int capacity) {
		lru = LRU.newInstance(capacity);
	}

	public int get(int key) {
		Integer value = lru.get(key);
		return value == null ? -1 : value;
	}

	public void set(int key, int value) {
		lru.put(key, value);
	}

}

class LRU<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = -5569197187984561732L;

	private final int capacity;

	static <K, V> LRU<K, V> newInstance(int capacity) {
		return new LRU<>(capacity);
	}

	private LRU(int capacity) {
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > capacity;
	}

}
