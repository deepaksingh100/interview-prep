package me.deepak.interview.multithreading;

/*
 * https://stackoverflow.com/questions/16689449/printing-even-and-odd-using-two-threads-in-java
 * https://www.baeldung.com/java-even-odd-numbers-with-2-threads
*/
public class PrintEvenOdd {

	public static void main(String[] args) {
		Printer print = new Printer();
		Thread t1 = new Thread(new EvenOddTask(print, 10, false), "Odd");
		Thread t2 = new Thread(new EvenOddTask(print, 10, true), "Even");
		t1.start();
		t2.start();
	}

}

class EvenOddTask implements Runnable {

	private Printer printer;
	private int max;
	private boolean even;

	EvenOddTask(Printer printer, int max, boolean even) {
		this.printer = printer;
		this.max = max;
		this.even = even;
	}

	@Override
	public void run() {

		int number = even ? 2 : 1;
		while (number <= max) {

			if (even) {
				printer.printEven(number);
			} else {
				printer.printOdd(number);
			}
			number += 2;
		}

	}

}

class Printer {

	private volatile boolean even;

	synchronized void printEven(int number) {
		while (!even) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println(Thread.currentThread().getName() + ":" + number);
		even = false;
		notifyAll();
	}

	synchronized void printOdd(int number) {
		while (even) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println(Thread.currentThread().getName() + ":" + number);
		even = true;
		notifyAll();
	}

}
