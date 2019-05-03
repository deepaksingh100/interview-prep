package me.deepak.interview.multithreading.producer_consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/*
 * used blocking queue
 */
class Producer1 implements Runnable {

	private BlockingQueue<Integer> queue;

	Producer1(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(new Random().nextInt(1000));
				queue.put(i);
				System.out.println("Produced : " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
