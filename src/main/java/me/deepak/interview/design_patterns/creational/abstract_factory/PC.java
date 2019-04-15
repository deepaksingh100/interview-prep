package me.deepak.interview.design_patterns.creational.abstract_factory;

public class PC implements Computer {

	@Override
	public String getRAM() {
		return "PC RAM";
	}

	@Override
	public String getHDD() {
		return "PC HDD";
	}

	@Override
	public String getCPU() {
		return "PC CPU";
	}

}
