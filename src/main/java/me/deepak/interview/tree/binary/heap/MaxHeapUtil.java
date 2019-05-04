package me.deepak.interview.tree.binary.heap;

import static me.deepak.interview.sort.utils.SwapUtil.swap;

import java.util.List;

import me.deepak.interview.tree.binary.beans.Heap;

public final class MaxHeapUtil {

	private MaxHeapUtil() {
	}

	public static Heap buildMaxHeap(List<Integer> list) {
		Heap maxHeap = new Heap();
		maxHeap.setHeap(list);
		maxHeap.setSize(list.size());

		// since lastsize / 2 nodes in heap does not have children, we only
		// call maxHeapify on first size / 2 nodes
		for (int i = maxHeap.getSize() / 2; i >= 0; i--) {
			maxHeapify(maxHeap, i);
		}
		return maxHeap;
	}

	public static void maxHeapify(Heap maxHeap, int root) {
		int left = left(root);
		int right = right(root);

		// let current largest value is at root
		int largest = root;

		List<Integer> heap = maxHeap.getHeap();
		int heapSize = maxHeap.getSize();

		if (left < heapSize && heap.get(left) > heap.get(largest)) {

			// new largest found
			largest = left;
		}
		if (right < heapSize && heap.get(right) > heap.get(largest)) {

			// new largest found
			largest = right;
		}

		// if root has not the largest value, swap largest & root, call maxheapify on
		// largest
		if (largest != root) {
			swap(heap, largest, root);
			maxHeapify(maxHeap, largest);
		}
	}

	public static int heapMaximum(Heap maxHeap) {
		return maxHeap.getHeap().get(0);
	}

	public static int heapExtractMax(Heap maxHeap) {
		int heapSize = maxHeap.getSize();
		if (heapSize < 1) {
			throw new IllegalArgumentException("Heapsize is zero");
		}
		List<Integer> heap = maxHeap.getHeap();
		int max = heap.get(0);

		// replace heap[0] by heap[size - 1], decrement size by 1
		heap.set(0, heap.get(--heapSize));
		maxHeap.setSize(heapSize);

		// call maxheapify on shorter heap
		maxHeapify(maxHeap, 0);
		return max;
	}

	public static void heapIncreaseKey(Heap maxHeap, int index, int key) {
		List<Integer> heap = maxHeap.getHeap();
		if (key < heap.get(index)) {
			throw new IllegalArgumentException("New key is smaller than current key");
		}

		// set new valid key at index
		heap.set(index, key);

		// swapping parent & child till heap property is not restored
		while (index > 0 && heap.get(parent(index)) < heap.get(index)) {
			swap(heap, index, parent(index));
			index = parent(index);
		}
	}

	public static void maxHeapInsert(Heap maxHeap, int key) {

		// increase heap size by 1
		int heapSize = maxHeap.getSize();
		heapSize++;
		maxHeap.setSize(heapSize);
		
		// set Integer.MIN_VALUE at last index
		maxHeap.getHeap().set(heapSize - 1, Integer.MIN_VALUE);

		// Now call heapIncreaseKey with last index
		heapIncreaseKey(maxHeap, heapSize - 1, key);
	}

	private static int parent(int child) {
		return (child - 1) / 2;
	}

	private static int left(int parent) {
		return 2 * parent + 1;
	}

	private static int right(int parent) {
		return 2 * parent + 2;
	}

}
