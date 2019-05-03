package me.deepak.interview.multithreading.producer_consumer;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/*
 * used await signalall
 */
class Producer3 implements Runnable {

	private Lock lock;
	private Condition condition;
	private Queue<Integer> queue;
	private int maxSize;

	Producer3(Lock lock, Condition condition, Queue<Integer> queue, int maxSize) {
		this.lock = lock;
		this.condition = condition;
		this.queue = queue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			lock.lock();
			try {
				while (queue.size() >= maxSize) {
					try {
						System.out.println("Queue is full. Producer is waiting.");
						condition.await();
						Thread.sleep(new Random().nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				queue.add(i);
				condition.signalAll();
				System.out.println("Produced : " + i);
			} finally {
				lock.unlock();
			}
		}
	}

}
