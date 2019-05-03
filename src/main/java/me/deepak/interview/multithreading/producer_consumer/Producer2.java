package me.deepak.interview.multithreading.producer_consumer;

import java.util.Queue;
import java.util.Random;

/*
 * used wait notifyall
 */
class Producer2 implements Runnable {

	private Queue<Integer> queue;
	private int maxSize;

	Producer2(Queue<Integer> queue, int maxSize) {
		this.queue = queue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			synchronized (queue) {
				while (queue.size() >= maxSize) {
					try {
						System.out.println("Queue is full. Producer is waiting.");
						queue.wait(new Random().nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				queue.add(i);
				queue.notifyAll();
				System.out.println("Produced : " + i);
			}
		}
	}

}
