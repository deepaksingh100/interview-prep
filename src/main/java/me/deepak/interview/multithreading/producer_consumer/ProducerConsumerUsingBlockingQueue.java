package me.deepak.interview.multithreading.producer_consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * used blocking queue
 */
public class ProducerConsumerUsingBlockingQueue {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
		ProducerTask producerTask = new ProducerTask(queue);
		ConsumerTask consumerTask = new ConsumerTask(queue);
		System.out.println("Producer and Consumer has been started");
		new Thread(producerTask).start();
		new Thread(consumerTask).start();
	}

	private static final class ProducerTask implements Runnable {

		private BlockingQueue<Integer> queue;

		private ProducerTask(BlockingQueue<Integer> queue) {
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
					Thread.currentThread().interrupt();
				}
			}
		}

	}

	private static final class ConsumerTask implements Runnable {

		private BlockingQueue<Integer> queue;

		private ConsumerTask(BlockingQueue<Integer> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			for (int i = 0; i < 20; i++) {
				try {
					Thread.sleep(new Random().nextInt(1000));
					System.out.println("Consumed : " + queue.take());
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
	}

}