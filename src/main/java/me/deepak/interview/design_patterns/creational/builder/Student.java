package me.deepak.interview.design_patterns.creational.builder;

public final class Student {
	private final int rollNo;
	private final String name;
	private final int age;

	private Student(Builder builder) {
		this.rollNo = builder.rollNo;
		this.name = builder.name;
		this.age = builder.age;
	}

	public static final class Builder {
		private int rollNo;
		private String name;
		private int age;

		public static Builder newInstance() {
			return new Builder();
		}

		private Builder() {
		}

		// setters

		public Builder rollNo(int rollNo) {
			this.rollNo = rollNo;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder age(int age) {
			this.age = age;
			return this;
		}

		public Student build() {
			return new Student(this);
		}
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", age=" + age + "]";
	}

}
