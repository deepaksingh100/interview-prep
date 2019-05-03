package me.deepak.interview.multithreading.producer_consumer;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/*
 * used await signalall
 */
class Consumer3 implements Runnable {

	private Lock lock;
	private Condition condition;
	private Queue<Integer> queue;

	Consumer3(Lock lock, Condition condition, Queue<Integer> queue) {
		this.lock = lock;
		this.condition = condition;
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			lock.lock();
			try {
				while (queue.isEmpty()) {
					try {
						System.out.println("Queue is empty. Consumer is waiting.");
						condition.await();
						Thread.sleep(new Random().nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				long consumedValue = queue.remove();
				condition.signalAll();
				System.out.println("Consumed : " + consumedValue);
			} finally {
				lock.unlock();
			}
		}
	}

}
