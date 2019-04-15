package me.deepak.interview.design_patterns.creational.abstract_factory;

public class AnimalFactory implements AbstractFactory<Animal> {

	@Override
	public Animal create(String type) {
		switch (type) {
		case "dog":
			return new Dog();
		case "duck":
			return new Duck();
		default:
			return null;
		}
	}

}
