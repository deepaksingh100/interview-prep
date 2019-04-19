package me.deepak.interview.multithreading.producer_consumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*used await signalall*/

public class Main3 {

	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayDeque<>(10);
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		Producer3 producer = new Producer3(lock, condition, queue, 10);
		Consumer3 consumer = new Consumer3(lock, condition, queue);
		System.out.println("Producer and Consumer has been started");
		new Thread(producer).start();
		new Thread(consumer).start();
	}

}
