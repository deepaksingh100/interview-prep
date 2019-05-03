package me.deepak.interview.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {

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

	/*
	 * The writeObject method is responsible for writing the state of the object for
	 * its particular class so that the corresponding readObject method can restore
	 * it. The default mechanism for saving the Object's fields can be invoked by
	 * calling out.defaultWriteObject. The method does not need to concern itself
	 * with the state belonging to its super classes or subclasses. State is saved
	 * by writing the individual fields to the ObjectOutputStream using the
	 * writeObject method or by using the methods for primitive data types supported
	 * by DataOutput.
	 */
	private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
		System.out.println("writeObject in pojo");
		objectOutputStream.defaultWriteObject();
	}

	/*
	 * The readObject method is responsible for reading from the stream and
	 * restoring the classes fields. It may call in.defaultReadObject to invoke the
	 * default mechanism for restoring the object's non-static and non-transient
	 * fields. The defaultReadObject method uses information in the stream to assign
	 * the fields of the object saved in the stream with the correspondingly named
	 * fields in the current object. This handles the case when the class has
	 * evolved to add new fields. The method does not need to concern itself with
	 * the state belonging to its super classes or subclasses. State is saved by
	 * writing the individual fields to the ObjectOutputStream using the writeObject
	 * method or by using the methods for primitive data types supported by
	 * DataOutput.
	 */
	private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
		System.out.println("readObject in pojo");
		objectInputStream.defaultReadObject();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollno=" + rollno + ", thread=" + thread + "]";
	}

}
