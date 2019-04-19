package me.deepak.interview.randomized_select.partition;

import static me.deepak.interview.sort.utils.SwapUtil.swap;

import java.util.Random;

public class RandomizedPartition {

	private static final Random RANDOM_NUMBER_GENERATOR = new Random();

	public int randomizedPartition(int[] a, int start, int end) {
		int randomIndex = RANDOM_NUMBER_GENERATOR.nextInt(end - start + 1) + start;
		swap(a, end, randomIndex);
		return new Partition().partition(a, start, end);
	}

}
