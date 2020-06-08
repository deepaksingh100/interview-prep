package me.deepak.interview.test;

class A1 {
	static {
		System.out.println("static a");
	}

	{
		System.out.println("inst a");
	}

	A1() {
		System.out.println("cons a");
	}

}

class B1 extends A1 {
	static {
		System.out.println("static b");
	}

	B1() {
		System.out.println("cons b");
	}

	{
		System.out.println("inst b");
	}

}

public class Test2 {
	public static void main(String[] args) {
		A1 a;
		a = new B1();
		new B1();
	}
}