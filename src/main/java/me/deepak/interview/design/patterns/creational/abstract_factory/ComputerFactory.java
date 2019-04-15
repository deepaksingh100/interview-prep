package me.deepak.interview.design.patterns.creational.abstract_factory;

public class ComputerFactory implements AbstractFactory<Computer> {

	@Override
	public Computer create(String type) {
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
