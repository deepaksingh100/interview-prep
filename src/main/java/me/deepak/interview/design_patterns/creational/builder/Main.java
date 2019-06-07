package me.deepak.interview.design_patterns.creational.builder;

public class Main {

	public static void main(String[] args) {
		Student student = Student.Builder.newInstance().rollNo(1).name("Deepak").age(23).build();
		System.out.println(student);
		student = Student.Builder.newInstance().rollNo(2).name("Pankaj").age(22).build();
		System.out.println(student);
	}

}
