package me.deepak.interview.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * LRU Cache implementation using Linked Hash Map
 * 
 * https://www.geeksforgeeks.org/lru-cache-implementation/
 * https://www.geeksforgeeks.org/design-a-data-structure-for-lru-cache/
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache2 {

	// actual cache which holds key & value entries
	private final LRU<Integer, Integer> lru;

	// creates cache of given capacity
	public LRUCache2(int capacity) {
		lru = LRU.newInstance(capacity);
	}

	// returns value from cache if found, else return -1
	public int get(int key) {
		Integer value = lru.get(key);
		return value == null ? -1 : value;
	}

	// adds entry to cache of given key & value
	public void put(int key, int value) {
		lru.put(key, value);
	}

}

class LRU<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = -5569197187984561732L;

	private final int capacity;

	// static factory method to create new LRU Cache
	static <K, V> LRU<K, V> newInstance(int capacity) {
		return new LRU<>(capacity);
	}

	/*
	 * Constructs an empty LinkedHashMap instance with the specified initial
	 * capacity, load factor and ordering mode. accessOrder the ordering mode - true
	 * for access-order, false for insertion-order
	 */
	private LRU(int capacity) {
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}

	/*
	 * Returns true if this map should remove its eldest entry. This method is
	 * invoked by put and putAll after inserting a new entry into the map. It
	 * provides the implementor with the opportunity to remove the eldest entry each
	 * time a new one is added. This is useful if the map represents a cache: it
	 * allows the map to reduce memory consumption by deleting stale entries.
	 * 
	 * Returns: true if the eldest entry should be removed from the map; false if it
	 * should be retained.
	 */
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > capacity;
	}

}
