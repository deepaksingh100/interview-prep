package me.deepak.interview.design_patterns.creational.factory;

public class Server implements Computer {

	@Override
	public String getRAM() {
		return "Server RAM";
	}

	@Override
	public String getHDD() {
		return "Server HDD";
	}

	@Override
	public String getCPU() {
		return "Server CPU";
	}

}
