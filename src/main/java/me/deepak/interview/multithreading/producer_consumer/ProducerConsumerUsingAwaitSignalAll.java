package me.deepak.interview.multithreading.producer_consumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * used await signalall
 */
public class ProducerConsumerUsingAwaitSignalAll {

	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayDeque<>(10);
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		ProducerTask producerTask = new ProducerTask(lock, condition, queue, 10);
		ConsumerTask consumerTask = new ConsumerTask(lock, condition, queue);
		System.out.println("Producer and Consumer has been started");
		new Thread(producerTask).start();
		new Thread(consumerTask).start();
	}

	private static final class ProducerTask implements Runnable {

		private Lock lock;
		private Condition condition;
		private Queue<Integer> queue;
		private int maxSize;

		private ProducerTask(Lock lock, Condition condition, Queue<Integer> queue, int maxSize) {
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
							Thread.currentThread().interrupt();
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

	private static final class ConsumerTask implements Runnable {

		private Lock lock;
		private Condition condition;
		private Queue<Integer> queue;

		private ConsumerTask(Lock lock, Condition condition, Queue<Integer> queue) {
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
							Thread.currentThread().interrupt();
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

}