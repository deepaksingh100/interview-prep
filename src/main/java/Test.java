
class Animal {

	public void m1() {
		System.out.println("m1");
	}
	
	public void m2() {
		System.out.println("m2");
	}
	
}

class Dog extends Animal {
	
	public void m3() {
		System.out.println("m3");
	}
	
}

public class Test {
	 public static void main(String[] args) {
		Animal a = new Dog();
		Dog d = (Dog) a;
		//a.m3();
		d.m3();
		d.m1();
	}
 }