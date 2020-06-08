package me.deepak.interview.design.oops.e_commerce;

import java.util.List;

import me.deepak.interview.design.oops.e_commerce.entities.Product;
import me.deepak.interview.design.oops.e_commerce.services.LoginService;
import me.deepak.interview.design.oops.e_commerce.services.SearchService;
import me.deepak.interview.design.oops.e_commerce.services.SignupService;

public class Main {

	public static void main(String[] args) {

		// call signup api, if not signed up
		SignupService signupService = new SignupService();
		signupService.signup();

		// call login api, to login
		LoginService loginService = new LoginService();
		loginService.login();

		// call search service to populate search result page
		SearchService searchService = new SearchService();
		List<Product> products = searchService.search("shoe");

	}

}
