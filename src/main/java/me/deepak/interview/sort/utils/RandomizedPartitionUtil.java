package me.deepak.interview.sort.utils;

import static me.deepak.interview.sort.utils.SwapUtil.swap;
import static me.deepak.interview.sort.utils.PartitionUtil.partition;

import java.util.Random;

public final class RandomizedPartitionUtil {

	private RandomizedPartitionUtil() {
	}

	private static final Random RANDOM_NUMBER_GENERATOR = new Random();

	public static int randomizedPartition(int[] a, int start, int end) {

		// random index is generated in range [start, end]
		int randomIndex = RANDOM_NUMBER_GENERATOR.nextInt(end - start + 1) + start;
		swap(a, end, randomIndex);
		return partition(a, start, end);
	}

}
