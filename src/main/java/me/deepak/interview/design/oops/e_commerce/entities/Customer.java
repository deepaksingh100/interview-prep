package me.deepak.interview.design.oops.e_commerce.entities;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String name;
	private String email;
	private String mobile;
	private List<String> addresses;

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public List<Order> getOrders(int months) {

		// we will retrieve order of given last months
		return new ArrayList<>();
	}

}
