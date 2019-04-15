package me.deepak.interview.design.patterns.creational.abstract_factory;

public interface AbstractFactory<T> {

	T create(String type);

}
