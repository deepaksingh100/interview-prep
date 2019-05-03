
package me.deepak.interview.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * https://docs.oracle.com/javase/10/docs/api/java/io/Serializable.html
*/
public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Student student = new Student();
		student.setName("abc");
		student.setRollno(1);
		student.setThread(new Thread(() -> System.out.println("In Run")));
		System.out.println("Serialized : " + student);
		byte[] bytes = serialize(student);
		Student deserializedStudent = (Student) deserialize(bytes);
		System.out.println("Deserialized : " + deserializedStudent);
	}

	private static byte[] serialize(Object object) throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		System.out.println("writeObject");
		objectOutputStream.writeObject(object);
		objectOutputStream.close();
		return byteArrayOutputStream.toByteArray();
	}

	private static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
		System.out.println("readObject");
		return objectInputStream.readObject();
	}

}
