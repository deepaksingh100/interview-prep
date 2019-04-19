package me.deepak.interview.tree.binary.heap.max;

import java.util.List;

public class MaxHeapHelper {

	public int parent(int child) {
		return (child - 1) / 2;
	}

	public int left(int parent) {
		return 2 * parent + 1;
	}

	public int right(int parent) {
		return 2 * parent + 2;
	}

	public MaxHeap buildMaxHeap(List<Integer> list) {
		MaxHeap maxHeap = new MaxHeap();
		maxHeap.setHeap(list);
		maxHeap.setSize(list.size());
		for (int i = maxHeap.getSize() / 2; i >= 0; i--) {
			maxHeapify(maxHeap, i);
		}
		return maxHeap;
	}

	public void maxHeapify(MaxHeap maxHeap, int root) {
		int left = left(root);
		int right = right(root);
		int largest = root;
		List<Integer> heap = maxHeap.getHeap();
		int heapSize = maxHeap.getSize();
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

	public int heapMaximum(MaxHeap maxHeap) {
		return maxHeap.getHeap().get(0);
	}

	public int heapExtractMax(MaxHeap maxHeap) {
		int heapSize = maxHeap.getSize();
		if (heapSize < 1) {
			throw new IllegalArgumentException("Heapsize is zero");
		}
		List<Integer> heap = maxHeap.getHeap();
		int max = heap.get(0);
		heap.set(0, heap.get(--heapSize));
		maxHeap.setSize(heapSize);
		maxHeapify(maxHeap, 0);
		return max;
	}

	public void heapIncreaseKey(MaxHeap maxHeap, int index, int key) {
		List<Integer> heap = maxHeap.getHeap();
		if (key < heap.get(index)) {
			throw new IllegalArgumentException("New key is smaller than current key");
		}
		heap.set(index, key);
		while (index > 0 && heap.get(parent(index)) < heap.get(index)) {
			swap(heap, index, parent(index));
			index = parent(index);
		}
	}

	public void maxHeapInsert(MaxHeap maxHeap, int key) {
		int heapSize = maxHeap.getSize();
		heapSize++;
		maxHeap.setSize(heapSize);
		maxHeap.getHeap().set(heapSize - 1, Integer.MIN_VALUE);
		heapIncreaseKey(maxHeap, heapSize - 1, key);
	}

	private static void swap(List<Integer> heap, int i, int j) {
		int temp = heap.get(i);
		heap.set(i, j);
		heap.set(j, temp);
	}

}
