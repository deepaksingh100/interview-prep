package me.deepak.interview.multithreading.producer_consumer;

import java.util.ArrayDeque;
import java.util.Queue;

/*used wait notifyall*/

public class Main2 {

	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayDeque<>(10);
		Producer2 producer = new Producer2(queue, 10);
		Consumer2 consumer = new Consumer2(queue);
		System.out.println("Producer and Consumer has been started");
		new Thread(producer).start();
		new Thread(consumer).start();
	}

}
