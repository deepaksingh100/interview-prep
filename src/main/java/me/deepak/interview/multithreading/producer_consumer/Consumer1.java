package me.deepak.interview.multithreading.producer_consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/*used blocking queue*/

class Consumer1 implements Runnable {

	private BlockingQueue<Integer> queue;

	Consumer1(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(new Random().nextInt(1000));
				System.out.println("Consumed : " + queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
