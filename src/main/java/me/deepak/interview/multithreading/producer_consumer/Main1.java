package me.deepak.interview.multithreading.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*used blocking queue*/

public class Main1 {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
		Producer1 producer = new Producer1(queue);
		Consumer1 consumer = new Consumer1(queue);
		System.out.println("Producer and Consumer has been started");
		new Thread(producer).start();
		new Thread(consumer).start();
	}

}
