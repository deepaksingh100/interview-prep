package me.deepak.interview.multithreading.producer_consumer;

import java.util.Queue;
import java.util.Random;

/*
 * used wait notifyall
 */
class Consumer2 implements Runnable {

	private Queue<Integer> queue;

	Consumer2(Queue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					try {
						System.out.println("Queue is empty. Consumer is waiting.");
						queue.wait(new Random().nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				long consumedValue = queue.remove();
				queue.notifyAll();
				System.out.println("Consumed : " + consumedValue);
			}
		}
	}

}
