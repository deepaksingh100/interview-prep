package me.deepak.interview.string;

/*
 * https://youtu.be/6pLEwJP1Afk?t=1964
 * We can use + operator for concatenation as string in java, as + operator is overloaded as 
 * StringBuilder.append. Run command "javap -c PlusTest.class" & examine the output.
 * 
*/
public class PlusTest {

	public static void main(String[] args) {

		String s = "This " + "is " + Boolean.valueOf(true) + " plus " + "Test.";
		System.out.println(s);
	}

}
