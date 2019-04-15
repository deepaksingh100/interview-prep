package me.deepak.interview.design_patterns.creational.builder;

public class Main {

	public static void main(String[] args) {
		Student student = Student.Builder.newInstance().setRollNo(1).setName("Deepak").setAge(23).build();
		System.out.println(student);
		student = Student.Builder.newInstance().setRollNo(2).setName("Pankaj").setAge(22).build();
		System.out.println(student);
	}

}
