package me.deepak.interview.sort;

import static me.deepak.interview.sort.utils.SwapUtil.swap;
import static me.deepak.interview.tree.binary.heap.MaxHeapUtil.buildMaxHeap;
import static me.deepak.interview.tree.binary.heap.MaxHeapUtil.maxHeapify;

import java.util.List;

import me.deepak.interview.tree.binary.beans.Heap;

/*
 * See CLRS Heap Sort
*/
public final class HeapSort {

	private HeapSort() {
	}

	public static void sort(List<Integer> a) {
		Heap maxHeap = buildMaxHeap(a);
		int heapSize = maxHeap.getSize();

		// starting from last element
		for (int i = heapSize - 1; i >= 1; i--) {

			// swap ith element to first (max) element
			swap(maxHeap.getHeap(), 0, i);

			// decrease size of heap
			maxHeap.setSize(maxHeap.getSize() - 1);

			// max heapify a[0...i-1]
			maxHeapify(maxHeap, 0);
		}
	}

}
