package me.deepak.interview.design_patterns.creational.factory;

public class ComputerFactory {

	private ComputerFactory() {
	}

	public static Computer getComputer(String type) {
		switch (type) {
		case "pc":
			return new PC();
		case "server":
			return new Server();
		default:
			return null;
		}
	}

}
