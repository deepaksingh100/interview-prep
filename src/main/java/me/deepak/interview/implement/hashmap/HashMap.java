package me.deepak.interview.implement.hashmap;

/*
 * https://dzone.com/articles/custom-hashmap-implementation-in-java
*/
public class HashMap<K, V> {

	private Entry<K, V>[] buckets;
	private static final int INITIAL_CAPACITY = 1 << 4; // 16
	private int size = 0;

	public HashMap() {
		this(INITIAL_CAPACITY);
	}

	public HashMap(int capacity) {
		this.buckets = new Entry[capacity];
	}

	public void put(K key, V value) {
		Entry<K, V> newEntry = new Entry<>(key, value);
		int index = getHash(key) % getBucketSize();
		Entry<K, V> entry = buckets[index];
		if (entry == null) {
			buckets[index] = newEntry;
			size++;
		} else {

			// compare the keys see if key already exists
			while (entry.next != null) {
				if ((entry.key == null && key == null) || entry.key.equals(key)) {
					entry.value = value;
					return;
				}
				entry = entry.next;
			}
			if ((entry.key == null && key == null) || entry.key.equals(key)) {
				entry.value = value;
			} else {
				entry.next = newEntry;
				size++;
			}
		}
	}

	public V get(K key) {
		Entry<K, V> entry = buckets[getHash(key) % getBucketSize()];
		while (entry != null) {

			if ((entry.key == null && key == null) || entry.key.equals(key)) {
				return entry.value;
			}
			entry = entry.next;
		}
		return null;
	}

	private int getHash(K key) {
		return key == null ? 0 : key.hashCode();
	}

	private int getBucketSize() {
		return buckets.length;
	}

	static class Entry<K, V> {
		final K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

}
