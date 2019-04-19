package me.deepak.interview.sort;

import static me.deepak.interview.sort.utils.SwapUtil.swap;

import java.util.List;

import me.deepak.interview.tree.binary.heap.max.MaxHeap;
import me.deepak.interview.tree.binary.heap.max.MaxHeapHelper;

public class HeapSort {

	public void sort(List<Integer> a) {
		MaxHeapHelper helper = new MaxHeapHelper();
		MaxHeap maxHeap = helper.buildMaxHeap(a);
		int heapSize = maxHeap.getSize();
		for (int i = heapSize - 1; i >= 1; i--) {
			swap(maxHeap.getHeap(), 0, i);
			maxHeap.setSize(maxHeap.getSize() - 1);
			helper.maxHeapify(maxHeap, 0);
		}
	}

}
