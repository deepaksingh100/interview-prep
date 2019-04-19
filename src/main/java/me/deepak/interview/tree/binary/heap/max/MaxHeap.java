package me.deepak.interview.tree.binary.heap.max;

import java.util.List;

public class MaxHeap {

	private static final class Heap {
		private List<Integer> heap;
		private int size;
	}

	public int parent(int child) {
		return (child - 1) / 2;
	}

	public int left(int parent) {
		return 2 * parent + 1;
	}

	public int right(int parent) {
		return 2 * parent + 2;
	}

	public Heap buildMaxHeap(List<Integer> list) {
		Heap maxHeap = new Heap();
		maxHeap.heap = list;
		maxHeap.size = list.size();
		for (int i = maxHeap.size / 2; i >= 0; i--) {
			maxHeapify(maxHeap, i);
		}
		return maxHeap;
	}

	public void maxHeapify(Heap maxHeap, int root) {
		int left = left(root);
		int right = right(root);
		int largest = root;
		List<Integer> heap = maxHeap.heap;
		int heapSize = maxHeap.size;
		if (left < heapSize && heap.get(left) > heap.get(largest)) {
			largest = left;
		}
		if (right < heapSize && heap.get(right) > heap.get(largest)) {
			largest = right;
		}
		if (largest != root) {
			swap(heap, largest, root);
			maxHeapify(maxHeap, largest);
		}
	}

	public int heapMaximum(Heap maxHeap) {
		return maxHeap.heap.get(0);
	}

	public int heapExtractMax(Heap maxHeap) {
		int heapSize = maxHeap.size;
		if (heapSize < 1) {
			throw new IllegalArgumentException("Heapsize is zero");
		}
		List<Integer> heap = maxHeap.heap;
		int max = heap.get(0);
		heap.set(0, heap.get(--heapSize));
		maxHeap.size = heapSize;
		maxHeapify(maxHeap, 0);
		return max;
	}

	public void heapIncreaseKey(Heap maxHeap, int index, int key) {
		List<Integer> heap = maxHeap.heap;
		if (key < heap.get(index)) {
			throw new IllegalArgumentException("New key is smaller than current key");
		}
		heap.set(index, key);
		while (index > 0 && heap.get(parent(index)) < heap.get(index)) {
			swap(heap, index, parent(index));
			index = parent(index);
		}
	}

	public void maxHeapInsert(Heap maxHeap, int key) {
		int heapSize = maxHeap.size;
		heapSize++;
		maxHeap.size = heapSize;
		maxHeap.heap.set(heapSize - 1, Integer.MIN_VALUE);
		heapIncreaseKey(maxHeap, heapSize - 1, key);
	}

	private static void swap(List<Integer> heap, int i, int j) {
		int temp = heap.get(i);
		heap.set(i, j);
		heap.set(j, temp);
	}

}
