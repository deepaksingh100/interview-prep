package me.deepak.interview.design.patterns.creational.abstract_factory;

public class Dog implements Animal {

	@Override
	public String getAnimal() {
		return "Dog";
	}

	@Override
	public String makeSound() {
		return "Bark";
	}

}
