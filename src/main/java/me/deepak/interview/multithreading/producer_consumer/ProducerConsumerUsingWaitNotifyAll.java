package me.deepak.interview.multithreading.producer_consumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

/*
 * used wait notifyall
 */
public class ProducerConsumerUsingWaitNotifyAll {

	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayDeque<>(10);
		ProducerTask producerTask = new ProducerTask(queue, 10);
		ConsumerTask consumerTask = new ConsumerTask(queue);
		System.out.println("Producer and Consumer has been started");
		new Thread(producerTask).start();
		new Thread(consumerTask).start();
	}

	private static final class ProducerTask implements Runnable {

		private Queue<Integer> queue;
		private int maxSize;

		private ProducerTask(Queue<Integer> queue, int maxSize) {
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
							Thread.currentThread().interrupt();
						}
					}
					queue.add(i);
					queue.notifyAll();
					System.out.println("Produced : " + i);
				}
			}
		}

	}

	private static final class ConsumerTask implements Runnable {

		private Queue<Integer> queue;

		private ConsumerTask(Queue<Integer> queue) {
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
							Thread.currentThread().interrupt();
						}
					}
					long consumedValue = queue.remove();
					queue.notifyAll();
					System.out.println("Consumed : " + consumedValue);
				}
			}
		}

	}

}
