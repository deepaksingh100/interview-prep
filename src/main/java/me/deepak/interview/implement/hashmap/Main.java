package me.deepak.interview.implement.hashmap;

public class Main {

	public static void main(String[] args) {

		HashMap<String, String> map = new HashMap<>();
		map.put(null, "1");
		map.put(null, "2");
		System.out.println(map.get(null));

		System.out.println(map.get("1"));
	}

}
