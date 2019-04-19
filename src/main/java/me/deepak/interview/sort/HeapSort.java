package me.deepak.interview.sort;

import static me.deepak.interview.sort.utils.SwapUtil.swap;
import static me.deepak.interview.tree.binary.heap.MaxHeapUtil.buildMaxHeap;
import static me.deepak.interview.tree.binary.heap.MaxHeapUtil.maxHeapify;

import java.util.List;

import me.deepak.interview.tree.binary.heap.MaxHeap;

public final class HeapSort {

	private HeapSort() {
	}

	public static void sort(List<Integer> a) {
		MaxHeap maxHeap = buildMaxHeap(a);
		int heapSize = maxHeap.getSize();
		for (int i = heapSize - 1; i >= 1; i--) {
			swap(maxHeap.getHeap(), 0, i);
			maxHeap.setSize(maxHeap.getSize() - 1);
			maxHeapify(maxHeap, 0);
		}
	}

}
