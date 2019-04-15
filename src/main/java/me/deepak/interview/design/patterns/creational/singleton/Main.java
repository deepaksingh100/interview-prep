package me.deepak.interview.design.patterns.creational.singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		SerializableSingleton object = SerializableSingleton.getInstance();
		objectOutputStream.writeObject(object);
		System.out.println(object);

		ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		object = (SerializableSingleton) objectInputStream.readObject();
		System.out.println(object);
	}
}
