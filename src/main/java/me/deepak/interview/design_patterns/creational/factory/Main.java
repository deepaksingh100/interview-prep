package me.deepak.interview.design_patterns.creational.factory;

public class Main {

	public static void main(String[] args) {
		System.out.println(ComputerFactory.getComputer("pc"));
		System.out.println(ComputerFactory.getComputer("server"));
	}

}
