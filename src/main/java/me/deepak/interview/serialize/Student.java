package me.deepak.interview.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -158447326349547814L;

	private String name;
	private int rollno;
	private transient Thread thread;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
		System.out.println("writeObject in pojo");
		objectOutputStream.defaultWriteObject();
	}

	private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
		System.out.println("readObject in pojo");
		objectInputStream.defaultReadObject();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollno=" + rollno + ", thread=" + thread + "]";
	}

}
